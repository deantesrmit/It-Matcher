<#import "../masterTemplate.ftl" as layout />

<@layout.masterTemplate title="How_It_Works">
<#include "../fragment/banner.html">
    <div class="container">
        <div class = "row" id="how-it-works-2-col">
            <div class = "col-md-6">
                <h4>How It Works - Freelancer</h4>
                <p>IT Matcher is designed to fast and efficiently connect freelance developers with job opportunity's
                    suited to their specific needs. This is done by the use of our match-making algorithm.</p>
                <p>A Freelancer User is promoted to set up their profile after registering to the site, this is then
                    used in the match-making algorithm so when a job is posted that suit's that user's specific skill set
                    they are automatically added to the list of matching developers that the Job Poster will receive after
                    posting their Job. A Job poster can then send the user job opportunities as they arise.</p>
            </div>

            <div class = "col-md-6">
                <h4>How It Works - Job Poster</h4>
                <p>IT Matcher is designed to fast and efficiently connect Job Posters with Freelance developers
                    suited to their specific needs. This is done by the use of our match-making algorithm.</p>
                <p id="job-poster-col2">A Job Poster is promoted to set up their Job profile after registering to the site and when creating
                    new jobs, this is then used in the match-making algorithm to automatically recommend developers suited
                    to the Job's needs and requirements. A Job poster is then able to access their View Matches page and
                    send Job opportunities to developers who suit there needs.</p>
            </div>
        </div>

    </div>



</@layout.masterTemplate>
