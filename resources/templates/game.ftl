<#-- @ftlvariable name="data" type="tictactoe.IndexData" -->
<html>
    <body>
    <form action="game" enctype="multipart/form-data" method="POST">
    <table>

    <tr>
    <td>
        <#if boardString[0] == " ">
            <button name="val_0" value="${playerChar}" type="submit">${playerChar}</button>
        <#else>
            ${boardString[0]}
        </#if>
        <input name="val_0" width=1 value="${boardString[0]}" type="hidden">
    </td>
    <td>
        <#if boardString[1] == " ">
            <button name="val_1" value="${playerChar}" type="submit">${playerChar}</button>
        <#else>
            ${boardString[1]}
        </#if>
        <input name="val_1" width=1 value="${boardString[1]}" type="hidden">
    </td>
    <td>
        <#if boardString[2] == " ">
            <button name="val_2" value="${playerChar}" type="submit">${playerChar}</button>
        <#else>
            ${boardString[2]}
        </#if>
        <input name="val_2" width=1 value="${boardString[2]}" type="hidden">
    </td>
    </tr>
    <tr>
    <td>
        <#if boardString[3] == " ">
            <button name="val_3" value="${playerChar}" type="submit">${playerChar}</button>
        <#else>
            ${boardString[3]}
        </#if>
        <input name="val_3" width=1 value="${boardString[3]}" type="hidden">
    </td>
    <td>
        <#if boardString[4] == " ">
            <button name="val_4" value="${playerChar}" type="submit">${playerChar}</button>
        <#else>
            ${boardString[4]}
        </#if>
        <input name="val_4" width=1 value="${boardString[4]}" type="hidden">
    </td>
    <td>
        <#if boardString[5] == " ">
            <button name="val_5" value="${playerChar}" type="submit">${playerChar}</button>
        <#else>
            ${boardString[5]}
        </#if>
        <input name="val_5" width=1 value="${boardString[5]}" type="hidden">
    </td>
    </tr>
    <tr>
    <td>
        <#if boardString[6] == " ">
            <button name="val_6" value="${playerChar}" type="submit">${playerChar}</button>
        <#else>
            ${boardString[6]}
        </#if>
        <input name="val_6" width=1 value="${boardString[6]}" type="hidden">
    </td>
    <td>
        <#if boardString[7] == " ">
            <button name="val_7" value="${playerChar}" type="submit">${playerChar}</button>
        <#else>
            ${boardString[7]}
        </#if>
        <input name="val_7" width=1 value="${boardString[7]}" type="hidden">
    </td>
    <td>
        <#if boardString[8] == " ">
            <button name="val_8" value="${playerChar}" type="submit">${playerChar}</button>
        <#else>
            ${boardString[8]}
        </#if>
        <input name="val_8" width=1 value="${boardString[8]}" type="hidden">
    </td>
    </tr>

    </table>
    <input type="submit">
    </form>
    </body>
</html>
