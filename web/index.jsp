<html>

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <%--<meta charset="utf-8">--%>

    <title>Skill Matrix</title>

    <%--<link href="http://fonts.googleapis.com/css?family=Open+Sans:400" rel="stylesheet">--%>
    <link href="css/styles.css" rel="stylesheet">

</head>

<body>


<div class="main-content">

    <div class="nav">

        <input type="checkbox" id="menu"/>
        <label for="menu" id="nav-icon"> Hard Skills</label>
        <input type="checkbox" id="menu1"/>
        <label for="menu1" id="nav-icon"> Soft  Skills</label>
        <body>
        <form>
            <p><input type="search" name="q" placeholder="Поиск по сайту">
                <input type="submit" value="Найти"></p>
        </form>
        <%--{{#each this}}--%>
        <div class="multi-level">
            <script id="skills-template" type="x-handlebars-template">
                {{#each this}}
                <div class="item">
                    <input type="checkbox" id="{{columnNumber}}-{{rowNumber}}"/>

                    <img  src="images/click.png" class="arrow"><label for="{{rowNumber}}">{{name}}</label>
                    <label for="{{rowNumber}}">{{childList.length}}</label>

                    <ul>
                        {{#each childList}}
                        <li>
                            <div class="sub-item">
                                <input type="checkbox" id="{{rowNumber}}"/>

                                <img src="images/click.png" class="arrow"><label for="{{rowNumber}}">{{name}}</label>
                                <label for="{{rowNumber}}">{{childList.length}}</label>
                                <ul>
                                    {{#each childList}}
                                    <li>
                                        <div class="sub-item">
                                            <input type="checkbox" id="{{rowNumber}}"/>

                                            <img  src="images/click.png" class="arrow"><label
                                                for="{{rowNumber}}">{{name}}</label>
                                                <label for="{{rowNumber}}">{{childList.length}}</label>
                                            <ul>
                                                {{#each childList}}
                                                <li>
                                                    <div class="sub-item">
                                                        <input type="checkbox" id="{{rowNumber}}"/>
                                                        <label for="{{rowNumber}}">- {{name}}</label>
                                                        <label for="{{rowNumber}}">{{childList.length}}</label>
                                                    </div>
                                                </li>
                                                {{/each}}
                                            </ul>
                                            {{else}}
                                            <label for="{{rowNumber}}">- {{name}}</label>
                                            <label for="{{rowNumber}}">{{childList.length}}</label>

                                        </div>
                                    </li>
                                    {{/each}}
                                </ul>
                                {{else}}
                                <label for="{{rowNumber}}">- {{name}}</label>
                                <label for="{{rowNumber}}">{{childList.length}}</label>

                            </div>
                        </li>
                        {{/each}}
                    </ul>
                    {{else}}
                    <label for="{{rowNumber}}">- {{name}}</label>

                </div>
                {{/each}}
            </script>
        </div>


    </div>

</div>




<form role="form" method="post" action="/command" id="addElement">
    <input type="hidden" name="command" value="addelem">
    <input id="n-name" type="text" name="nw-name"  required autocomplete="off"><br>
    <div class="add-img">
        <input type="submit" value="Add element" id="second">
    </div>
</form>



<form role="form" method="post" action="/command" id="delElement">
    <input type="hidden" name="command" value="delelem">

    <div class="add-img">
        <input type="submit" value="Delete element" id="second">
    </div>
</form>



<form role="form" method="post" action="/command" id="changeName">
    <input type="hidden" name="command" value="chaName">

    <input id="ch-name" type="text" name="new-name"  required autocomplete="off"><br>

    <div class="add-img">
        <input type="submit" value="change" id="second">
    </div>
</form>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/handlebars-v4.0.11.js"></script>
<script src="js/all.js"></script>


</body>
</html>