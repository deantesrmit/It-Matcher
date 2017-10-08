<#import "../masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Login">
<#include "../fragment/banner.html">
<div class="container">
    <div class="row justify-content-center">
        <div class ="col">
            <h4 id ="login">Create your Job</h4>
            <form class = "createjob">
                <div class ="form-group">
                    <label for = "jobNameInput">Job Name</label>
                    <input type="text" class="form-control" id="jobNameInput" placeholder="Job Name">
                </div>
                <div class ="form-group">
                    <label for = "jobDescriptionInput">Job Description</label>
                    <input type="text" class="form-control" id="jobDescriptionInput" placeholder="Job Description">
                </div>
                <div class ="form-group">
                    <label for ="skillsRequired">Skills Required: Please hold down the control key to tick multiple options</label>
                    <select multiple class="form-control" id="skillsRequiredInput">
                        <option>HTML/CSS</option>
                        <option>PHP</option>
                        <option>Java</option>
                        <option>Javascript</option>
                        <option>Ruby</option>
                        <option>C++</option>
                        <option>Python</option>
                        <option>Perl</option>
                        <option>C#</option>
                        <option>C</option>
                        <option>Go</option>
                        <option>R</option>
                        <option>SQL</option>
                        <option>iOS: Swift</option>
                        <option>iOS: C Objective</option>
                        <option>Wordpress</option>
                        <option>SEO</option>
                        <option>Mobile Phone</option>
                        <option>Android</option>
                        <option>Graphic Design</option>
                        <option>Internet Marketing</option>
                        <option>Database Design</option>
                    </select>
                </div>
            <div class="form-group">
                <label for="educationInput">Desired Education Level:</label>
                <select class="form-control" id="educationInput">
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
            <div class ="form-group">
                <label for ="dateRequired">Date Required By:</label>
                <br/>
                <input type="date" name="dateRequiredInput">
            </div>
            <div class = "form-group">
                <label for "budget">Preferred Budget (If you would like to advertise a budget):</label>
                <input type="text" class="form-control" id="budgetInput" placeholder="Budget">
            </div>
            <a href="#" class="btn btn-primary btn-md">Create Job<i class="fa fa-sign-in"></i></a>
            </form>
        </div>
    </div>
</div>
</@layout.masterTemplate>