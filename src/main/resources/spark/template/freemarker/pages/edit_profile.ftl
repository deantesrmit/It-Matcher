<#import "../masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Edit Profile">
    <#include "../fragment/banner.html">

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-offset-5 col-md-4">
            <h4 id="login">${profile.id?? ? then('Edit Your', 'Create')} Profile</h4>
            <form class="form-login" action="${profile.id?? ? then(' /edit_profile/', ' /create_profile/')}" method="POST">
                <label for "location">Location</label>
                <input type="text" id="location" name="location" class="form-control input-sm chat-input" value="${profile.location!}" oninput=check_number_character(this) required/><br/>

                <label for "address">Address</label>
                <input type="text" id="address1" name="address1" class="form-control input-sm chat-input" value="${profile.address1!}"  oninput=check_number_character(this) required/><br/>

                <label for "suburb">Suburb</label>
                <input type="text" id="suburb" name="suburb" class="form-control input-sm chat-input" value="${profile.suburb!}"  oninput=check_number_character(this) required/><br/>

                <label for "state">State</label>
                <input type="text" id="state" name="state" class="form-control input-sm chat-input" value="${profile.state!}"  oninput=check_number_character(this) required /><br/>

                <label for "postCode">Postcode</label>
                <input type="text" id="postCode" name="postCode" class="form-control input-sm chat-input" value="${profile.postCode!}"  oninput=check_number_only(this) required/><br/>

                <label for "bio">Bio</label>
                <input type="text" id="bio" name="bio" class="form-control input-sm chat-input" value="${profile.bio!}"   required /><br/>

                 <label for "education">Education</label>
                    <Select name = "education">
                        <#list educations as edu>
                            <option id = "education" value= "${edu.id}"
                            <#if profile.education??>
                                <#if profile.education == edu.id>selected</#if>
                                </#if>>${edu.value}</option>
                        </#list>
                    </Select>


                  <label for "workExperience">WorkExperience</label>
                    <Select name="workExperience">
                        <#list workExperiences as exp>
                            <option id = "workExperience" value="${exp.id}"
                            <#if profile.workExperience??>
                             <#if profile.workExperience == exp.id>selected</#if>
                             </#if>>${exp.value}</option>
                        </#list>
                    </Select>

                <div class="wrapper">
                    <input type="submit" class="btn btn-primary btn-md"
                           value="${profile.id?? ? then('Edit Your', 'Create')}  Profile"/>
                </div>
            </form>
        </div>
    </div>
</div>
</@layout.masterTemplate>