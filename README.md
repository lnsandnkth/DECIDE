
# DECIDE()

This Github repository is aimed at solving the DECIDE()-project for the course DD2480.

![alt text](https://cdn.pixabay.com/photo/2018/03/14/15/33/earth-3225519_1280.png)

##Documentation

### What's DECIDE() ?

DECIDE() is part of a hypothetical anti-ballistic missile system. DECIDE() generates a boolean signal which represents if a missile interceptor should be launched ie outputs `true` / `false` or "YES" / "NO".    
This decision is took based on the input data points which represent radar tracking information. These points are processed by 15 LICs whose boolean outputs, assembled into a CMV, are combined using a LCM and stored into a PUM.
The PUV will then determine if each LIC's output should be considered or not in the decision to make. It is used to combine the PUM's values into a FUV which, if all of its values are `true`, will take the decision to launch an interceptor.

Order in which the data is used :
1. LIC Launch Interceptor Condition.
2. CMV Conditions Met Vector.
3. LCM Logical Connector Matrix.
4. PUM Preliminary Unlocking Matrix.
5. PUV Preliminary Unlocking Vector.
6. FUV Final Unlocking Vector.
7. Decision (boolean)

For more information check the [detailed specification](https://canvas.kth.se/courses/31884/files/4932282/download?wrap=1)

### How to build and run
0. (Any Java JRE Needed)
1. run `./gradlew check` to setup environment
2. run `./gradlew clean test` to run tests
3. tests should pass (no main function at the moment, demo DECIDE() runs are done in [MainTest](https://github.com/lnsandnkth/DECIDE/blob/main/src/test/java/MainTest.java))

##Way of Working:

| State        | Checklist           | done  |
| ------------- |:-------------:| -----:|
| Principles Established     | Principles and constraints are committed to by the team | x |
| | Principles and constraints are agreed to by the stakeholders. | x |
| | The tool needs of the work and its stakeholders are agreed. | x |
| | A recommendation for the approach to be taken is available. | x |
| | The context within which the team will operate is understood | x |
| | The constraints that apply to the selection, acquisition, and use of practices and tools are known | x |
| Foundation Established      | The key practices and tools that form the foundation of the way-of-working are selected. | x |
| | Enough practices for work to start are agreed to by the team | x |
| | All non-negotiable practices and tools have been identified. | x |
| | The gaps that exist between the practices and tools that are needed and the practices and tools that are available have been analyzed and understood | x |
| | The capability gaps that exist between what is needed to execute the desired way of working and the capability levels of the team have been analyzed and understood. | x |
| | The selected practices and tools have been integrated to form a usable way-of-working. | x |
| In Use | The practices and tools are being used to do real work. | x |
| | The use of the practices and tools selected are regularly inspected | x |
| | The practices and tools are being adapted to the team’s context. | x |
| | The use of the practices and tools is supported by the team | x |
| | Procedures are in place to handle feedback on the team’s way of working. | x |
| | The practices and tools support team communication and collaboration | x |
| In Place | The practices and tools are being used by the whole team to perform their work  | x |
| | All team members have access to the practices and tools required to do their work | x |
| | The whole team is involved in the inspection and adaptation of the way-of-working | x |
| Working well | Team members are making progress as planned by using and adapting the way-of-working to suit their current context | x |
| | The team naturally applies the practices without thinking about them. | - |
| | The tools naturally support the way that the team works. | x |
| | The team continually tunes their use of the practices and tools. | x |
| Retired | The team's way of working is no longer being used. | - |
|  | Lessons learned are shared for future use. | -  |

*State we are in*: Working well <br>
*Why*: Because we fulfil the previous requirements in the checklist. We are not yet accustomed enough to our way-of-working to be in the next one<br>
*What are the obstacles to reach the next state*: We need to get used to our environment more, so the way-of-working becomes natural to us <br>



## Authors

- [@lnsandnkth](https://www.github.com/lnsandnkth) *Leon Sandner* :  
    - created the github repo;
    - refactored the project (with the team) so we have less probability of merge conflicts and a better way-of-working;
    - did LIC6,11,12 and reviewed some of the others' LICs;
    - did a code test coverage check(idea by @mxyns): we have a 96% line coverage
    - wrote down the way-of-working in the README (and discussed it with the team)
    - looked up how to do ci in github (with actions/workflow) and did the initial configuration
- [@mxyns](https://www.github.com/mxyns) *Maxence Younsi*
  - project description / build instructions
- [@yuxin-miao](https://www.github.com/yuxin-miao) *Xinmiao Yu* :
  - did LIC0, 3, 8 with tests and reviewed others LICs;
  - did the calculation of PUM with test;
  - add global declarations;
  - did the main DECIDE() function and mainTest;
- [@sandy-e](https://www.github.com/sandy-e)
- [@noahra](https://www.github.com/noahra)


## Appendix

Any additional information goes here
