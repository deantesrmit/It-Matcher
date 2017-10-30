<#import "../masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Profile">
<#include "../fragment/banner.html">
    <div class="container">
        <div class="row justify-content-center">
            <div class = "row">
                <div class = "col"> </div>
                <div class = "col-12 col-md-auto">
                    <!-- Edit this to pull Freelancer name from database -->
                    <h4>Freelancer Profile</h4>
                </div>
                <div class = "col"></div>
            </div>
        </div>

        <div class="row pad-top">
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4><strong>List of auto-matched Jobs</strong></h4>
                    </div>
                    <div class="panel-body">
                        <!-- Edit this to pull applied jobs from database -->
                        <a href="/viewMatches" <button class="btn btn-success">Auto-matched Jobs</button></a>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4><strong>User Information</strong></h4>
                    </div>
                    <div class="panel-body">
                        <!-- Edit this to pull user info from database -->
                        </br>
                        <p>User ID:${users.id}</p>
                        <p>User Name: ${users.username}</p>
                        <p>First Name: <#if users.firstName??>${users.firstName}</#if></p>
                        <p>Last Name: <#if users.lastName??>${users.lastName}</#if> </p>
                        <p>Address: <#if profile.address1??>${profile.address1}</#if> </p>
                        <p>Suburb: <#if profile.suburb??>${profile.suburb}</#if> </p>
                        <p>State: <#if profile.state??>${profile.state}</#if> </p>
                        <p>Postcode: <#if profile.postcode??>${profile.postcode}</#if> </p>
                        <p>Bio: <#if profile.bio??>${profile.bio}</#if> </p>
                        <button class="btn btn-success">Edit User Information</button>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>


</@layout.masterTemplate>
