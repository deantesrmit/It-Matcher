
package com.itmatcher.service;

import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;

/**
 * @author Dean Tesoriero
 */
public class MatchServiceTest {
    //  @Spy
//  private FreeLancerRepository lancerRepository;
//  @InjectMocks
//  private MatchService matchService;
//
//  @Before
//  public void initMocks() {
//      MockitoAnnotations.initMocks(this);
//   }
//
//  @Test
//  public void findOneFreeLancerWithRequiredJava(){
////    when(lancerRepository.findFreeLancersByRequired(any(),any())).thenReturn(asList(mockFreeLancer("JAVA", "Sql")));
//
//    Job job = new Job();
//    job.setLanguages(asList(new Language("Java", CriteriaWeight.REQUIRED)));
//    job.setSkills(asList(new Skill("Sql", CriteriaWeight.HIGH_PREFERENCE)));
//
//    final List<FreelancerDto> scoredFreeLancers = matchService.findFreelancersForJob(1);
//    Assert.assertEquals(1, scoredFreeLancers.size());
//    Assert.assertTrue(hasCriteria(scoredFreeLancers.get(0).getFreeLancer().getLanguages(), "Java"));
//    Assert.assertEquals(5, scoredFreeLancers.get(0).getScore());
//  }
//
//  private boolean hasCriteria(List<? extends WeightedCriteria> criterias, String value) {
//    if(criterias == null )return false;
//    return criterias.stream().anyMatch(c -> c.getValue().equalsIgnoreCase(value));
//  }
//
//  private FreeLancer mockFreeLancer(String language, String skill) {
//    FreeLancer javaFreeLancer = new FreeLancer();
//    javaFreeLancer.setLanguages(asList(new Language(language)));
//    javaFreeLancer.setSkills(asList(new Skill(skill)));
//    return javaFreeLancer;
//  }
    private static int longest(int[] A) {
        int ans = 0;
        int[] len = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            len[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[i] >= A[j]) {
                    len[i] = Math.max(len[i], len[j] + 1);
                    ans = Math.max(ans, len[i]);
                }
            }
        }

        return ans;
    }

    @Test
    public void test() {
        final int longest = longest(new int[]{5, 3, 4, 8, 6, 7});
    }
}


