<%--
  Created by IntelliJ IDEA.
  User: lespons
  Date: 13.12.14
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <script src="/resources/js/kn.js"></script>

    <script src="/resources/js/app.js"></script>

    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.1.1/css/bootstrap-combined.min.css">
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>

<div class="explorer">
    <div class="tree">
        <ul>
            <li data-bind="click: openFile">
                <span><i class="icon-folder-open"></i>System</span>
                <ul data-bind="template: { name: 'treeElement', foreach: $data.files }"></ul>
            </li>
        </ul>

        <script id="treeElement" type="text/html">
            <li data-bind="click: $data.openFile, attr:{'id':id}">
                <span><i class="icon-folder-close"></i><div data-bind="text: name"></div></span>
                <ul data-bind="template: { name: 'treeElement', foreach: $data.files }">
                </ul>
            </li>
        </script>
    </div>
    <div class="list">
        <table class="table">
            <caption data-bind="text: path">..//</caption>
            <thead>
            <tr>
                <th>Name</th>
                <th>Type</th>
            </tr>
            </thead>
            <tbody data-bind="foreach: folderFiles">
            <tr data-bind="click: $data.openFile">
                <td data-bind="text: name"></td>
                <td data-bind="text: type"></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
