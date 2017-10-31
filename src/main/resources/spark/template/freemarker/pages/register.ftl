<#import "../masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Register">
<#include "../fragment/banner.html">
<div class="container">
        <div class="row justify-content-center">
            <div class = "row">
                <div class = "col"> </div>
                    <div class = "col-12 col-md-auto">
                        <h4 id ="login">Register for IT Matcher</h4>
                        <form class="form-register" action="/register/" method="POST">
                            <#if error??>
                                <div class="alert alert-danger">
                                ${error}
                                </div>
                            </#if>
                                <input type="text" name="username" class="form-control input-sm chat-input" placeholder="Email Address" required />
                                </br>
                                <input type="password"  oninput= checkpassword(this)   id="userPassword" class="form-control input-sm chat-input" placeholder="Password" required/>
                                </br>
                                <input type="password" id="repeatPassowrd" class="form-control input-sm chat-input" placeholder="Confirm Password"

                                       oninput= check(this) required />
                                </br>
                            <input type="text" name="firstName" class="form-control input-sm chat-input" placeholder="First Name" required/>
                            </br>
                                <input type="text" id="lastName" class="form-control input-sm chat-input" placeholder="Last Name" required/>
                                </br>
                                <label for="registerType">Registration Type</label>
                                <select class ="form-control" name="registrationType">
                                    <option value="POSTER">Job Poster</option>
                                    <option value="FREELANCER">Freelancer</option>
                                </select>
                                </br>
                                <div class="wrapper">
                                    <div class="wrapper">
                                            <div class="wrapper">
                                                <input type="submit" class="btn btn-primary btn-md" value="register" />
                                            </div>
                                    </div>
                                </div>
                            </form>
                    </div>
                <div class = "col"></div>
            </div>
        </div>
</div>
</@layout.masterTemplate>
