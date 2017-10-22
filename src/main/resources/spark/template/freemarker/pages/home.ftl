<#import "../masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Home">
<div class="containerhome">
    <div class="container">
        <!-- Example row of columns -->
        <div class="row">
            <div class="col">
                <h1 class="companyh1">IT MATCHER</h1>
                <p class="tagline">Matching your IT project to someone who can get IT done</p>
                <div class = "buttons d-none d-md-block" id="buttons-home">
                    <a class="btn btn-default " href="/register.html" role="button">Join Now</a>
                    <a class="btn btn-default" href="/howitworks.html" role="button">Discover More</a>
                </div>
            </div>
            <div class="col"></div>
        </div>
    </div> <!-- /container -->
</div>
</div>
</@layout.masterTemplate>