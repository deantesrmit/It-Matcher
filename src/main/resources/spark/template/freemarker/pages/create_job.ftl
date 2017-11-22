<#import "../masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Login">
  <#include "../fragment/banner.html">
<div class="container">
  <div class="row justify-content-center">
    <div class="col">
      <h4 id="login">Create your Job</h4>
      <form class="createjob" class="form-login" action="/create_job/" method="POST">
        <#if error??>
            <div class="alert alert-danger">
            ${error}
            </div>
        </#if>
        <div class="form-group">
          <label for="jobNameInput">Job Name</label>
          <input type="text" name="title" class="form-control" id="jobNameInput" placeholder="Job Title">
        </div>
        <div class="form-group">
          <label for="jobDescriptionInput">Job Description</label>
          <input type="text" name="description" class="form-control" id="jobDescriptionInput"
                 placeholder="Job Description" value="${description!}">
        </div>
        <div class="form-group">
          <label for="skillsRequired">Skills Required: Please hold down the control key to tick multiple options</label>
          <select multiple name="skillsInput" class="form-control" id="skillsRequiredInput">
              <#list skills! as skill>
                    <option value="${skill.id}" <#if skillsInput?seq_contains(skill.id + "")> selected="true"</#if>>
                      ${skill.value}
                    </option>
              </#list>
          </select>
        </div>
        <div class="form-group">
          <label for="educationInput">Desired Education Level:</label>

          <select name="education" class="form-control" id="educationInput">
            <#list educations! as educationItem>
                <option value="${educationItem.id}" <#if education! == educationItem.id + ''>selected=true</#if>>
                    ${educationItem.value}
                </option>
            </#list>
          </select>
        </div>
        <div class="form-group">
          <label for="dateRequired">Date Required By:</label>education.value
          <br/>
          <input name="dueDate" type="date" name="dateRequiredInput">
        </div>
        <div class="form-group">
          <label for "budget">Preferred Budget (If you would like to advertise a budget):</label>
          <input name="budget" type="text" class="form-control" id="budgetInput" placeholder="Budget">
        </div>
        <input type="submit" class="btn btn-primary btn-md" value="Create Job"/>
      </form>
    </div>
  </div>
</div>
</@layout.masterTemplate>