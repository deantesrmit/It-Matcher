<#import "../masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Register">
<#include "../fragment/banner.html">
<div class="container">
        <div class="row justify-content-center">
            <div class = "row">
                <div class = "col"> </div>
                    <div class = "col-12 col-md-auto">
                        <h4 id ="login">Register for IT Matcher</h4>
                            <div class="form-register">
                                <form class="form-register" action="/register/" method="POST">
                                <input type="email" id="email" class="form-control input-sm chat-input" placeholder="Email Address" required/>
                                </br>
                                <input type="password" id="userPassword" class="form-control input-sm chat-input" placeholder="Password"

                                       oninput= checkpassword(this)  required/>
                                </br>
                                <input type="password" id="repeatPassowrd" class="form-control input-sm chat-input" placeholder="Confirm Password"

                                       oninput= check(this) required />
                                </br>
                                <input type="text" id="firstName" class="form-control input-sm chat-input" placeholder="First Name" required/>
                                </br>
                                <input type="text" id="lastName" class="form-control input-sm chat-input" placeholder="Last Name" required/>
                                </br>
                                <label for="registerType">Registration Type</label>
                                <select class ="form-control" id = "registrationType">
                                <option>Job Lister</option>
                                <option>Freelancer</option>
                                </select>
                                </br>
                                <div class="wrapper">
                                    <span class="group-btn">
                                         <input type="submit" class="btn btn-primary btn-md" value="register" />

                                    </span>
                                </div>
                                </form>
                            </div>
                    </div>
                <div class = "col"></div>
            </div>
        </div>
</div>
</@layout.masterTemplate>
