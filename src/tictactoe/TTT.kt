package tictactoe

class TTT(parent: Array<Array<String>>, depth: Int) {
    private var children = arrayOf<TTT>()
    private var board = arrayOf<Array<String>>()
    private val depth: Int
    private var numXWinningChildren: Int
    private var numOWinningChildren: Int
    private var numTieChildren: Int
    var stringRepresentation: String
    private val allBoards = HashMap<String, TTT>();

    init {
        numXWinningChildren = 0
        numOWinningChildren = 0
        numTieChildren = 0
        stringRepresentation = "";

        this.depth = depth;

        for (x in 0..2) {
            var array = arrayOf<String>()
            for (o in 0..2) {
                array += parent[x][o];
                stringRepresentation += parent[x][o];
            }
            board += array

        }

        val result = getResult()
        if (result.equals(Result.XWIN)) {
            numXWinningChildren++
        } else if (result.equals(Result.OWIN)) {
            numOWinningChildren++
        } else {
            numTieChildren++;

            // If this board ties, then recurse down the children
            var doingX = (depth.rem(2)==0);
            for (line in parent.indices) {
                for (cell in parent[line].indices) {
                    if (parent[line][cell] == " ") {
                        //println("Making new cell at $line x $cell")
                        var newBoard = arrayOf<Array<String>>()
                        for (x in 0..2) {
                            var array = arrayOf<String>()
                            for (o in 0..2) {
                                array += parent[x][o];
                            }
                            newBoard += array
                        }

                        if (doingX) {
                            newBoard[line][cell] = "X"
                        } else {
                            newBoard[line][cell] = "O"
                        }

                        val newChild = TTT(newBoard, depth + 1);
                        children += newChild

                        numXWinningChildren += newChild.numXWinningChildren
                        numOWinningChildren += newChild.numOWinningChildren
                        numTieChildren += newChild.numTieChildren

                        allBoards.putAll(newChild.allBoards)
                    }
                }
            }
        }

        println ("Adding board "+stringRepresentation)
        allBoards.put(stringRepresentation, this)

    }

    fun getBestChild(): TTT {
        val winningChildren = children.filter{it.getResult()!=Result.TIE}
        children.forEach{ c-> c.print(false)}
        println("WinningChildren size="+winningChildren.size)

        if (!winningChildren.isEmpty()) {
            return winningChildren.get(0)
        }
        return children.sortedBy { numXWinningChildren }.get(0)
    }

    fun getResult(): Result {
        // Check horizontally
        var result: Result
        for (line in board) {
            result = getResultFromLine(line)
            if (!result.equals(Result.TIE)) {
                return result
            }
        }

        // Check vertically
        result = getResultFromLine(arrayOf(board[0][0], board[1][0], board[2][0]));
        if (!result.equals(Result.TIE)) {
            return result
        }

        result = getResultFromLine(arrayOf(board[0][1], board[1][1], board[2][1]));
        if (!result.equals(Result.TIE)) {
            return result
        }

        result = getResultFromLine(arrayOf(board[0][2], board[1][2], board[2][2]));
        if (!result.equals(Result.TIE)) {
            return result
        }

        // Check diagonally
        result = getResultFromLine(arrayOf(board[0][0], board[1][1], board[2][2]));
        if (!result.equals(Result.TIE)) {
            return result
        }

        result = getResultFromLine(arrayOf(board[0][2], board[1][1], board[2][0]));
        if (!result.equals(Result.TIE)) {
            return result
        }

        return Result.TIE
    }

    fun getResultFromLine(line: Array<String>): Result {
        var isAllX: Boolean
        var isAllO: Boolean

        isAllX = true
        isAllO = true

        for (cell in line) {
            if (cell.equals("X")) {
                isAllO = false
            } else if (cell.equals("O")) {
                isAllX = false
            } else {
                isAllX = false
                isAllO = false
            }
        }

        if (isAllX) {
            return Result.XWIN
        }

        if (isAllO) {
            return Result.OWIN
        }
        return Result.TIE
    }

    fun findBoardFromString(boardString: String): TTT? {
        println ("We have "+allBoards.size+" boards")
        allBoards.keys.forEach({b-> println("Board name: "+b)})
        val ttt = allBoards.get(boardString)
        return ttt
    }



    fun print(recursive: Boolean) {
        println("depth $depth # children $numXWinningChildren/$numOWinningChildren/$numTieChildren -----------------")
        println(stringRepresentation+"\n")
        println(getResult())
        for (line in board) {
            for (cell in line) {
                print("$cell ")
            }
            println()
        }


        if (recursive) {
            for (child in children) {
                child.print(recursive)
            }
        }

    }
}

fun main(args: Array<String>) {
    var board = arrayOf<Array<String>>()
    for (x in 0..2) {
        var array = arrayOf<String>()
        for (y in 0..2) {
            array += " ";
        }
        board += array
    }

    val tictactoe = TTT(board, 0)
    tictactoe.print(true)

    val inputtedBoard = "XX X  OO"
    tictactoe.findBoardFromString(inputtedBoard)?.print(false)
}
