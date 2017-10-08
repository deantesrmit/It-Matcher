<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <img height="50px" src="/img/logo.png">
            <a class="navbar-brand" href="/">Home</a>
            <a class="navbar-brand" href="#">About Us</a>
            <a class="navbar-brand" href="/register/">Register</a>
            <a class="navbar-brand" href="#">How It Works</a>
            <a class="navbar-brand" href="/profile/">Profile</a>
        </div>
        <#if !userDetails??>
            <div class="nav navbar-nav navbar-right">
                <a class="navbar-brand" href="/login">LOGIN</a>
            </div>
        <#else>
             Account Type: ${userDetails.accountType}
            <div class="nav navbar-nav navbar-right">
                <form method="post" action="/logout/">
                    <input  type="submit" class="navbar-brand" id="logout" value="logout" />
                </form>
            </div>
        </#if>
    </div>
</nav>