<#import "../masterTemplate.ftl" as layout />

<@layout.masterTemplate title="User Information">
<#include "../fragment/banner.html">
    <div class="container">

        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <div class="panel panel-default">
                    <div class="panel-heading">Update User Information</div>
                    <div class="panel-body">

                        <form id="Update-Info" action="" method="post">

                            <div class="form-group">
                                <label>First Name</label>
                                <input type="text" class="form-control" name="firstname" id="UserFirstName" placeholder="First name" >
                            </div>

                            <div class="form-group">
                                <label>Last Name</label>
                                <input type="text" class="form-control" name="lastname" id="UserLastName" placeholder="Last name" >
                            </div>

                            <div class="form-group">
                                <label>Phone 1</label>
                                <input type="text" class="form-control" name="ph1" id="Phone1" placeholder="(00)000 000 00" >
                            </div>

                            <div class="form-group">
                                <label>Phone 2</label>
                                <input type="text" class="form-control" name="ph2" id="Phone2" placeholder="0400000000" >
                            </div>

                            <div class="form-group">
                                <label>Email Address</label>
                                <input type="email" class="form-control" name="email" id="UserEmail" placeholder="Email" >
                            </div>

                            <div class="form-group">
                                <label>Address</label>
                                <input type="text" class="form-control" name="address" id="UserAddress" placeholder="Address" >
                            </div>

                            <div class="form-group">
                                <label>Suburb</label>
                                <input type="text" class="form-control" name="suburb" id="UserSuburb" placeholder="Suburb" >
                            </div>

                            <div class="form-group">
                                <label>State</label>
                                <select name="state" class="btn btn-default dropdown-toggle" placeholder="Select State">
                                    <ul class="dropdown-menu">
                                        <li>QLD</li>
                                        <li>NSW</li>
                                        <li>NT</li>
                                        <li>WA</li>
                                        <li>VIC</li>
                                        <li>TAS</li>
                                        <li>ACT</li>
                                    </ul>
                            </div>

                            <div class="form-group">
                                <label>Post Code</label>
                                <input type="text" class="form-control" name="postcode" id="UserPostCode" placeholder="0000" >
                            </div>

                            <div class="form-group">
                                <label>Education History</label>
                                <textarea class="form-control" name="EduHistory" id="UserEdu" placeholder="Enter education history here." cols="80" rows="10" >
                            </div>

                            <div class="form-group">
                                <label>Bio</label>
                                <textarea class="form-control" name="bio" id="UserBio" placeholder="Enter Bio here." cols="80" rows="10" >
                            </div>

                            <button type="submit" class="btn btn-primary">Submit</button>

                        </form>
                    </div>
                </div>
            </div>
        </div>
</div>


</@layout.masterTemplate>
