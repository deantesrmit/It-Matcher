<#macro masterTemplate title="Welcome">
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>

<#include "fragment/menu.ftl">

<#nested />

<#include "fragment/footer.html">

</body>
</html>


<script src="/js/jquery.min.js"></script>
<script src="/js/poppers.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</#macro>