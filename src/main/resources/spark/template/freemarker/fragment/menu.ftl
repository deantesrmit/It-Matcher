<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">

        <!--Nav bar for Large and up viewpoints -->
        <div class="navbar-header d-none d-lg-block">
            <img height="50px" src="/img/logo.png">
            <a class="navbar-brand" href="/">Home<p class = "navbar-separator"> | </p></a>
            <a class="navbar-brand" href="/aboutus">About Us<p class = "navbar-separator"> | </p></a>
            <a class="navbar-brand" href="/register/">Register<p class = "navbar-separator"> | </p></a>
            <a class="navbar-brand" href="/howitworks">How It Works<p class = "navbar-separator"> | </p></a>
            <a class="navbar-brand" href="/profile/">Profile</a>
        </div>
    <#if !userDetails??>
        <div class="nav navbar-nav navbar-right  d-none d-lg-block">
            <a class="navbar-brand" href="/login">LOGIN</a>
        </div>
    <#else>
        <div class = "d-none d-lg-block">Account Type: ${userDetails.accountType}</div>
        <div class="nav navbar-nav navbar-right d-none d-lg-block">
            <form method="post" action="/logout/">
                <input  type="submit" class="navbar-brand" id="logout" value="logout" />
            </form>
        </div>
    </#if>

        <!--Nav bar for Medium and up viewpoints -->
        <div class="navbar-header d-none d-md-block d-lg-none">
            <img height="50px" src="/img/logo.png">
            <a class="navbar-brand" href="/">Home<p class = "navbar-separator-md"> | </p></a>
            <a class="navbar-brand" href="/aboutus">About Us<p class = "navbar-separator-md"> | </p></a>
            <a class="navbar-brand" href="/register/">Register<p class = "navbar-separator-md"> | </p></a>
            <a class="navbar-brand" href="/howitworks">How It Works<p class = "navbar-separator-md"> | </p></a>
            <a class="navbar-brand" href="/profile/">Profile</a>
        </div>
    <#if !userDetails??>
        <div class="nav navbar-nav navbar-right  d-none d-md-block d-lg-none">
            <a class="navbar-brand" href="/login">LOGIN</a>
        </div>
    <#else>
        <div class = "d-none d-md-block">Account Type: ${userDetails.accountType}</div>
        <div class="nav navbar-nav navbar-right d-none d-md-block d-lg-none">
            <form method="post" action="/logout/">
                <input  type="submit" class="navbar-brand" id="logout" value="logout" />
            </form>
        </div>
    </#if>

        <!--Nav bar for Small and Extra Small viewpoints -->
        <nav class="navbar navbar-toggleable navbar-light bg-faded d-md-none d-lg-none d-xl-none">
            <img height="50px" src="/img/logo.png">
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <a class="navbar-brand" href="#"></a>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/aboutus">About Us</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/howitworks">How it Works</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/profile">Profile</a>
                    </li>
                <#if !userDetails??>
                    <li class="nav-item">
                        <a class="nav-link" href="/login">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/register">Register</a>
                    </li>
                <#else>
                    <li class="nav-item">
                        <a class="nav-link" href="/logout/">
                            <form method="post" action="/logout/">
                                <input  type="submit" class="navbar-brand" id="logout" value="logout" />
                            </form>
                        </a>
                    </li>
                </#if>
                </ul>
            </div>
        </nav>

    </div>
</nav>