<#import "../masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Login">
  <#include "../fragment/banner.html">
<div class="container">
  <div class="row justify-content-center">
    <div class="col">
      <h4 id="login">Create your Job</h4>
      <form class="createjob" class="form-login" action="/create_job/" method="POST">
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
            <option value="1">HTML/CSS</option>
            <option value="2">PHP</option>
            <option value="3">Java</option>
            <option value="4">Javascript</option>
            <option value="5">Ruby</option>
            <option value="6">C++</option>
            <option value="7">Python</option>
            <option value="8">Perl</option>
            <option value="9">C#</option>
            <option value="10">C</option>
            <option value="11">Go</option>
            <option value="12">R</option>
            <option value="13">SQL</option>
            <option value="14">iOS: Swift</option>
            <option value="15">iOS: C Objective</option>
            <option value="16">Wordpress</option>
            <option value="17">SEO</option>
            <option value="18">Mobile Phone</option>
            <option value="19">Android</option>
            <option value="20">Graphic Design</option>
            <option value="21">Internet Marketing</option>
            <option value="22">Database Design</option>
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