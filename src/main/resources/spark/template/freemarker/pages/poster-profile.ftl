<#import "../masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Profile">
<div class="containerhome">
    <div class="container">

        <div class="row justify-content-center">
            <div class = "row">
                <div class = "col"> </div>
                <div class = "col-12 col-md-auto">
                    <!-- Edit this to pull Freelancer name from database -->
                    <h4>Job Poster Profile</h4>
                </div>
                <div class = "col"></div>
            </div>
        </div>

        <div class="row pad-top">
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4><strong>Your Jobs</strong></h4>
                    </div>
                    <div class="panel-body">
                        <!-- Edit this to pull listed jobs from database -->
                        You currently have no listed Jobs.
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
                        Phone 1: <br>
                        Phone 2: <br>
                        Email Address: <br>
                        Address: <br>
                        State: <br>
                        Suburb: <br>
                        Post Code: <br>
                        Education History: <br>
                        Bio: <br>
                        <button class="btn btn-success">Edit User Information</button>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>


</@layout.masterTemplate>