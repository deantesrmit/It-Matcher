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
                 placeholder="Job Description">
        </div>
        <div class="form-group">
          <label for="skillsRequired">Skills Required: Please hold down the control key to tick multiple options</label>
          <select multiple name="skills" class="form-control" id="skillsRequiredInput">
              <#list skills! as skill>
                    <option value="${skill.id}">${skill.value}</option>
              </#list>
          </select>
        </div>
        <div class="form-group">
          <label for="educationInput">Desired Education Level:</label>
          <select name="education" class="form-control" id="educationInput">
            <option>Senior Secondary</option>
            <option>Certificate I</option>
            <option>Certificate II</option>
            <option>Certificate III</option>
            <option>Certificate IV</option>
            <option>Diploma</option>
            <option>Advanced Diploma, Associate Degree</option>
            <option>Bachelor Degree</option>
            <option>Bachelor Honors Degree, Graduate Certificate, Graduate Diploma</option>
            <option>Masters Degree</option>
            <option>Doctoral Degree</option>
          </select>
        </div>
        <div class="form-group">
          <label for="dateRequired">Date Required By:</label>
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