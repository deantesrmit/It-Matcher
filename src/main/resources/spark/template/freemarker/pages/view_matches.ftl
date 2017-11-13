<#import "../masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Login">
<#include "../fragment/banner.html">
    <div class="container">
        <h4 id="login">View Your Matches Below</h4>
        <br/>
        <div class="matches">
            <div class="row" id="heading">
                <div class="col-sm-2">
                    Job Name
                </div>
                <div class="col-sm-3">
                    Job Description
                </div>
                <div class="col-sm-2">
                    Location
                </div>
                <div class="col-sm-2">
                    Due Date
                </div>
                <div class="col-sm-1">
                    Budget
                </div>
                <div class="col-sm-1">
                    Accept
                </div>
                <div class="col-sm-1">
                    Decline
                </div>
            </div>
            <div class="row listings">
                <div class="col-sm-2">
                    Motorcycle Website
                </div>
                <div class="col-sm-3">
                    We required a website to load our motorcycles for sale on.
                </div>
                <div class="col-sm-2">
                    Gold Coast
                </div>
                <div class="col-sm-2">
                    01/12/2017
                </div>
                <div class="col-sm-1">
                    $7500
                </div>
                <div class="col-sm-1">
                    <form class="form-login" action="/viewMatches/" method="POST">
                        <input type="hidden" name="answer" value="1" />
                        <input type="hidden" name="jobID" value="100" />
                        <input type="hidden" name="freelancerID" value="100" />
                        <input type="submit" class="btn btn-primary btn-md" value="Accept Job" />
                    </form>

                </div>
                <div class="col-sm-1">
                    <a href="#" class="btn btn-danger">Decline<i class="fa fa-sign-in"></i></a>
                </div>
            </div>
            <hr/>
            <div class="row listings">
                <div class="col-sm-2">
                    Motorcycle Website
                </div>
                <div class="col-sm-3">
                    We required a website to load our motorcycles for sale on.
                </div>
                <div class="col-sm-2">
                    Gold Coast
                </div>
                <div class="col-sm-2">
                    01/12/2017
                </div>
                <div class="col-sm-1">
                    $7500
                </div>
                <div class="col-sm-1">
                    <a href="#" class="btn btn-success">Accept<i class="fa fa-sign-in"></i></a>
                </div>
                <div class="col-sm-1">
                    <a href="#" class="btn btn-danger">Decline<i class="fa fa-sign-in"></i></a>
                </div>
            </div>
        </div>
</div>
</@layout.masterTemplate>