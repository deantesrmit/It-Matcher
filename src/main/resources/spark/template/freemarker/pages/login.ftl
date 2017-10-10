<#import "../masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Login">
<#include "../fragment/banner.html">
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-offset-5 col-md-4">
            <h4 id="login">Login to IT Matcher</h4>
            <form class="form-login" action="/login/" method="POST">
                <#if error??>
                    <div class="alert alert-danger">
                        ${error}
                    </div>
                </#if>
                <input type="text" id="username" name="username" class="form-control input-sm chat-input" placeholder="username"/>
                </br>
                <input type="password" id="password" name="password" class="form-control input-sm chat-input" placeholder="password"/>
                </br>
                <div class="wrapper">
                    <input type="submit" class="btn btn-primary btn-md" value="login" />
                </div>
            </form>
        </div>
    </div>
</div>
</@layout.masterTemplate>