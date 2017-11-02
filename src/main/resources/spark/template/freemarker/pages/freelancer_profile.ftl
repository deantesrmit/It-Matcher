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
                        <p>User ID:${users.id!}</p>
                        <p>User Name: ${users.username!}</p>
                        <p>First Name: ${users.firstName!}</p>
                        <p>Last Name: ${users.lastName!}</p>
                        <p>Address: ${profile.address1!}</p>
                        <p>Suburb: ${profile.suburb!}</p>
                        <p>State: ${profile.state!}</p>
                        <p>Postcode: ${profile.postcode!}</p>
                        <p>Bio: ${profile.bio!}</p>
                        <button class="btn btn-success">Edit User Information</button>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>


</@layout.masterTemplate>
