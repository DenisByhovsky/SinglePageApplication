<html>

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html;charset=windws-1251"/>
    <%--<meta charset="utf-8">--%>

    <title>Skill Matrix</title>

    <%--<link href="http://fonts.googleapis.com/css?family=Open+Sans:400" rel="stylesheet">--%>
    <link href="css/styles.css" rel="stylesheet">

</head>

<body>


<div class="main-content">

    <div class="nav">

        <ul class="head-menu">
            <li class="sub-point"><input type="checkbox" id="menu"/>
                <label for="menu" id="nav-icon"> Hard Skills</label></li>
            <li class="sub-point"> <input type="checkbox" id="menu1"/>
                <label for="menu1" id="nav-icon"> Soft  Skills</label></li>
            <li class="sub-point-1">
                <input id="spterm" type="text" name="spterm" placeholder="Search?"><br />
                <div id="spresult"> </div>
            </li>
        </ul>
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
                                <input type="checkbox" id="{{columnNumber}}-{{rowNumber}}"/>

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

                            </div>
                        </li>
                        {{/each}}
                    </ul>


                </div>
                {{/each}}
            </script>
        </div>


    </div>

</div>



<ul class="footer-menu">
<li class="foot-item">
<form role="form" method="post" action="/command" id="addElement">
    <input type="hidden" name="command" value="add">
    <input id="n-name" type="text" name="name"  required autocomplete="off"><br>
    <div class="add-img">
        <input type="submit" onclick="AddElem()" value="Add element" id="second">
    </div>
</form></li>
    </li>

    <li class="foot-item">
<form role="form" method="post" action="/command" id="delElement">
    <input type="hidden" name="command" value="deleteElem">

    <div class="add-img">
        <input type="submit" onclick="deleteElem()"  value="Delete element" id="second">
    </div>
</form>
    </li>

    <li class="foot-item">
<form role="form" method="post" action="/command" id="changeName">
    <input type="hidden" name="command" value="changeName">

    <input id="ch-name" type="text" name="name"  required autocomplete="off"><br>

    <div class="add-img">
        <input type="submit" onclick="changeName()"   value="Change name" id="second">
    </div>
</form>
    </li>
</ul>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/handlebars-v4.0.11.js"></script>
<script src="js/all.js"></script>


</body>
</html>