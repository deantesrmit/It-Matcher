<#import "../masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Edit Profile">
    <#include "../fragment/banner.html">

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-offset-5 col-md-4">
            <h4 id="login">${profile.id?? ? then('Edit Your', 'Create')} Profile</h4>
            <form class="form-login" action="${profile.id?? ? then(' /edit_profile/', ' /create_profile/')}" method="POST">
                <label for "location">Location</label>
                <input type="text" id="location" name="location" class="form-control input-sm chat-input"
                       <#if profile.location??>value="${profile.location}"</#if>/><br/>

                <label for "address">Address</label>
                <input type="text" id="address1" name="address1" class="form-control input-sm chat-input"
                       <#if profile.suburb??>value="${profile.address1}"</#if>/><br/>

                <label for "suburb">Suburb</label>
                <input type="text" id="suburb" name="suburb" class="form-control input-sm chat-input"
                       <#if profile.suburb??>value="${profile.suburb}"</#if>/><br/>

                <label for "state">State</label>
                <input type="text" id="state" name="state" class="form-control input-sm chat-input"
                       <#if profile.state??>value="${profile.state}"</#if>/><br/>

                <label for "postCode">Postcode</label>
                <input type="text" id="postCode" name="postCode" class="form-control input-sm chat-input"
                       <#if profile.postCode??>value="${profile.postCode}"</#if>/><br/>

                <label for "bio">Bio</label>
                <input type="text" id="bio" name="bio" class="form-control input-sm chat-input"
                       <#if profile.bio??>value="${profile.bio}"</#if>/><br/>

                <label for "education">Education</label>
                <Select>
                <List>
                    <option value="${education.id}">${education.educationName}</option>
                </List>
                </Select>


                <!--
                <select>
                    <option value="1">Senior Secondary</option>
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
                -->

                <label for "workExperience">WorkExperience</label>
                <input type="text" id="workExperience" name="workExperience" class="form-control input-sm chat-input"
                       <#if profile.workExperience??>   value="${profile.workExperience}"</#if> /><br/>

                <div class="wrapper">
                    <input type="submit" class="btn btn-primary btn-md"
                           value="${profile.id?? ? then('Edit Your', 'Create')}  Profile"/>
                </div>
            </form>
        </div>
    </div>
</div>
</@layout.masterTemplate>