<#import "../masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Edit Profile">
<#include "../fragment/banner.html">
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-offset-5 col-md-4">
            <h4 id="login">Edit Your Profile</h4>
            <form class="form-login" action="/edit_profile/" method="POST">
                <label for "bio">Bio</label>
                <input type="text" id="bio" name="bio" class="form-control input-sm chat-input" placeholder="Bio"/>
                </br>
                <label for "location"</label></br>
                <input type="text" id="location" name="location" class="form-control input-sm chat-input" placeholder="location"/>
                </br>
                <label for "education"</label><br/>
                <input type="text" id="education" name="education" class="form-control input-sm chat-input" placeholder="education"/>
                </br>
                <label for "workExperience"</label><br/>
                <input type = "text" id="workExperience" name="workExperience" class="form-control input-sm chat-input" placeholder="workExperience"/>
                <div class="wrapper">
                    <input type="submit" class="btn btn-primary btn-md" value="Update Profile" />
                </div>

            </form>
        </div>
    </div>
</div>
</@layout.masterTemplate>