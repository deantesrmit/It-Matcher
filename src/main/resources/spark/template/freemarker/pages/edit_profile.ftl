<#import "../masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Edit Profile">
<#include "../fragment/banner.html">
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-offset-5 col-md-4">
            <h4 id="login">Edit Your Profile</h4>
            <form class="form-login" action="/edit_profile/" method="POST">

                <label for "location">Location</label>
                <input type="text" id="location" name="location" class="form-control input-sm chat-input"
                value=<#if profile.location??>"${profile.location}"</#if>/><br/>

                <label for "address">Address</label>
                <input type="text" id="address1" name="address1" class="form-control input-sm chat-input"
                value=<#if profile.suburb??>"${profile.address1}"</#if>/><br/>

                <label for "suburb">Suburb</label>
                <input type="text" id="suburb" name="suburb" class="form-control input-sm chat-input"
                value=<#if profile.suburb??>"${profile.suburb}"</#if>/><br/>

                <label for "state">State</label>
                <input type="text" id="state" name="state" class="form-control input-sm chat-input"
                value=<#if profile.state??>"${profile.state}"</#if>/><br/>

                <label for "postCode">Postcode</label>
                <input type="text" id="postCode" name="postCode" class="form-control input-sm chat-input"
                value=<#if profile.postCode??>"${profile.postCode}"</#if>/><br/>

                <label for "bio">Bio</label>
                <input type="text" id="bio" name="bio" class="form-control input-sm chat-input"
                value=<#if profile.bio??>"${profile.bio}"</#if>/><br/>

                <label for "education">Education</label>
                <select>
                  <option value="1" >Senior Secondary</option>
                  <option value="2">Certificate I</option>
                  <option value="3">Certificate II</option>
                  <option value="4">Certificate III</option>
                  <option value="5">Certificate IV</option>
                  <option value="6">Diploma</option>
                  <option value="7">Advanced Diploma, Associate Degree</option>
                  <option value="8">Bachelor Degree</option>
                  <option value="9">Bachelor Honors Degree, Graduate Certificate, Graduate Diploma</option>
                  <option value="10">Masters Degree</option>
                  <option value="11">Doctoral Degree</option>
                </select>

                <label for "workExperience">WorkExperience</label>
                <input type="text" id="workExperience" name="workExperience" class="form-control input-sm chat-input"
                value=<#if profile.workExperience??>"${profile.workExperience}"</#if> /><br/>

                <div class="wrapper">
                    <input type="submit" class="btn btn-primary btn-md" value="Update Profile" />
                </div>

            </form>
        </div>
    </div>
</div>
</@layout.masterTemplate>