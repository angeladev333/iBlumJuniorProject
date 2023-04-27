# iBlüm Technical Interview Assignment 

For Junior candidates, this assignment should be provided *before* the interview, but is *not* required before the interview, but should be completed shortly after.

For Intermediate and Expert candidates, this assignment is to be done *before* the interview to allows the candidate to have more time to complete the assignment without being rushed for time.

You may keep a copy of this document or notes thereof, specifically the *Interview Questions* section in front of you during the interview if it will make you feel more comfortable.

## Junior, Intermediate and Expert Developer 

The assignment is to gauge understanding of basic programming concepts and knowledge of using Git.

* Write a program in your language of choice that returns a string containing the numbers 1 to 105.  But for multiples of three print `Devhaus` instead of the number; for multiples of five print `Learning`; for multiples of seven print `Model`; for multiples of both three and five print `Devhaus Learning`; for multiples of both three and seven print `Devhaus Model`;  for multiples of both five and seven print `Learning Model`; for multiples of all of three, five and seven print `iBlüm` (note the umlaut). 

* Go overboard in documenting your methods.  (Not the inner workings, just on the functions signatures themselves).  Generate documentation from your code

  * `Java: use javadoc
  * JavaScript/TypeScript: use jsdoc or typedoc
  * Python: PyDoc
  * Go: godoc

* Create a main function that calls the function and outputs the result to the console. 

* Write an automated test that proves that your code works with the test platform of your choice if not listed below:

  * Java: use JUnit and [AssertJ](https://assertj.github.io/doc/) assertions.
  * JavaScript/TypeScript: use [Jest](https://jestjs.io)
  * Python: PyTest
  * Go: `testing` package

* Upload the code to GitHub. 

* For Junior candidates specifically... Prepare a 2-minute maximum presentation on how your code works, where the audience would be another junior developer. A link to the video and GitHub should be provided to HR so we can review.

## Intermediate and Expert Developer for Back-end 

The assignment is to gauge understanding of creating a RESTful service, Spring Boot and Docker integration.  Links are provided to reduce the difficulty.

* Create a Spring boot app that calls your function.  Start from [Spring Initalizr](https://start.spring.io) and add the *Spring web* dependency.  Then make an endpoint for `/` to display the result of the function that was created above and make sure it is set to `text/plain` content type.

* Have a [`@SpringBootTest`](https://spring.io/guides/gs/testing-web/) to prove your code works automatically.

* Make a [*multi-stage Dockerfile*](https://docs.docker.com/develop/develop-images/multistage-build/) that compiles your code and executes your test; the final stage must be built on top of `openjdk` and must have a `CMD` that runs your server code.

* Your code must pass [Prettier](https://prettier.io) checks using the appropriate language plugins.  Python code should be formatted using [black](https://pypi.org/project/black/).  Doing the formatting verification as part of the pipeline is a plus.

* Use the code in [Appendix/Publish Workflow](#publish-workflow) as a [GitHub Action](https://docs.github.com/en/actions/quickstart).

* Provide the image link and git hub repo link prior to the Technical interview.  Make sure your image is _public_ and other people can do a `docker pull ghcr.io/<username>/<imagename>`.

* Prepare a 5-minute maximum presentation on how your code works, where the audience would be a junior developer. 

## Intermediate and Expert Developer for Front-end 

The assignment is to gauge understanding of using React JS, TypeScript, and Docker integration.  Links are provided to reduce the difficulty.

* Make a ReactJS app using TypeScript that has a state that starts with an empty string; the render function should have a `<pre>` tag containing the state value; have a `useEffect` hook that replaces the state of with the output of the function.  There should be no use of `any`.

* Add a [Jest](https://jestjs.io/) test with [`@testing-library/react`](https://testing-library.com/docs/react-testing-library/intro/) to test your component.

* Make a [*multi-stage Dockerfile*](https://docs.docker.com/develop/develop-images/multistage-build/) that compiles your code and executes your test. The final stage must copy the built bundle on top of a `nginx` container when accessing /.  The image must support x86 at minimum. (which is the default for Windows and Intel Macs, if you’re using an M1 mac you’d have to make the necessary adjustments). 

* Your TypeScript code must conform to [Prettier](https://prettier.io) style.

* Use the code in [Appendix/Publish Workflow](#publish-workflow) as a [GitHub Action](https://docs.github.com/en/actions/quickstart).

* Provide the image link and git hub repo link prior to the Technical interview.  Make sure your image is _public_ and other people can do a `docker pull ghcr.io/<username>/<imagename>`.

* Prepare a 5-minute maximum presentation on how your code works, where the audience would be a junior developer. 

## Expert Developer (tier 1)

This role expects to perform integration of three separate components (database, backend and front end) into a single deployment.  In addition, will 

* Modify the backend that was done in intermediate developer to add [Spring Data JPA](https://spring.io/projects/spring-data-jpa) and a MySQL database that would be accessed using JPA (the table creation can be either JPA or Liquibase); the table has two columns:  `id as int`, `output as varchar(200)`.  Add a separate Spring component that has a `@PostConstruct` that will load the output of the function into the table if the table is empty. 

* Add a new endpoint `/json` that reads the database and outputs a JSON array.

* Have an integration test using testcontainers to prove the backend load to the database works. 

* Add the Jacoco plugin to generate a coverage report for the backend. 

* Add the Javadoc plugin to generate documentation for the backend. 

* On the front-end add another state that starts with an empty array and modify the useEffect to make a typed Axios call to get the data from the http://localhost:1776/json into the second state.  Add to the render function to contain as second `<pre>` tag that contains the output of `JSON.stringify(dataFromJson, null, 2)` .

* Add a [Jest](https://jestjs.io/) test with [`@testing-library/react`](https://testing-library.com/docs/react-testing-library/intro/) and a *mock* out the call to the backend.  Ensure a coverage report is generated.

* Add the tyepdoc to generate documentation for the front end.


* The Docker images must be created to support `linux/amd64` and at least one `linux/arm*` architecture.

* Create a `docker-compose.yml` file that would build and deploy the front-end, back-end that is published in the Github container registry and MySQL with the front-end exposed to a random port so we can access the ReactJS app and the backend exposing http://localhost:1776 so the ReactJS app can make the Axios call from the browser.

* Reorganize your code so that the docker compose file, front end and back end are in a single Git repository along with a README.md on how to install this.  In addition, publish the coverage reports and generated documentation into Github pages via actions.  Provide a link to the repo prior to the interview.  The test by the evaluators is to clone your repo and then `docker compose up --build` on the repository root.  

* Create an [Expo snack](https://snack.expo.dev) that has a copy of your component and generates the same output using React Native components.  Note we are expecting the code to be in TypeScript.  Provide a link to the snack prior to the interview.

* Prepare a 10-minute maximum presentation on how your code works; how the deployment to the registry is implemented and how to manage the changes where the audience would be an intermediate developer.

## Expert Back-end Developer (tier 2)

The assignment is more typical of what we would be doing which uses Kafka messaging and GRPC endpoints and focused more on integration and back-end processing along with document generation.

* Write an openapi spec for the `/json` endpoint and generate documentation using Redoc.
* Create one or more Docker images to serve the Redoc API spec, TypeDoc and Javadoc files via HTTP.

* Create a new populator console app that would publish to kafka the results of the function to Kafka one entry per message, keyed with the index.
* Remove the the `@PostConstruct` on JPA and replace it with a `@KafkaListener`.
* Add grpc support to the backend service and add the following protobuf

  ```protobuf
  syntax = "proto3";
  message RowRequest {
    int32 index = 1;
  }
  message RowsRequest {
  }
  message RowResponse {
    int32 index = 1;
    string row = 2;
  }
  service FizzBuzz {
    /**
     * Returns a single row
     */
    rpc Row(RowRequest) returns (RowResponse) {}
    /**
     * Returns all the rows as a stream
     */
    rpc Rows(RowsRequest) returns (stream RowResponse) {}
  }
  ```
* Create a console app that would implement the protobuf that takes in an argument which is the index and call `Row` rpc to display the output, if no index is provided it should output to the console the results of the `Rows` rpc.

* Both new apps should be in the repo and have a bash script called `build.sh` which will use the appropriate build tool based on your language.  (e.g. Maven/Gradle for java, yarn/npm for NodeJS, Makefile for C/C++)

* Prepare a 10-minute maximum presentation on how your code works; how the deployment to the registry is implemented and how to manage the changes where the audience would be an intermediate developer.
 
# Interview questions 

Here are the interview questions we may ask you to see if you are a good fit with our corporate values: *Courage*, *Learning Culture*, *Integrity*, *Collaboration*, *Outcome Oriented*.  We provide this to enable candidates not to be surprised with *gotcha* questions, the panel will ask questions based on how they perceive your confidence level on the topic based on your resume.  

## HR questions again

These questions may have already been asked by the first HR interview (but the panel will not be privy to those interview).  Use that fact as a chance of refining the answers you had provided HR.

* **Explain `git rebase`**.  It's not the most common operation in git but it is the one we use quite often to keep our history clean improving the integrity of the system.  HR will only ask this if you had indicated in your resume that you have experience using Git.

* **Describe what you do with your home lab**.  Our industry is one that changes rapidly, and if you want to stay in this industry you have to ahead of the learning curve.  And that takes time... time you cannot normally take within your office hours.  So you're probably going to have to do this learning and experimentations at home.  How have you used your home lab to keep up?

* _(For those who are still employed)_ **How you plan to transition your work to your successors?** 

## Intermediate and up
These questions are reserved for those who had experience already.

* **How do you prepare for a daily meeting?** 

* **Describe how you would enable our corporate values.** 

* **If you were given unlimited authority, but neither unlimited funds nor unlimited time, how would you improve the work experience for your team?** 

## Feedback on the process

* **How much time did you spend on the assignment?** Include any learning and research time you may have spent.

* _(For non-senior developer candidates)_ **Did you try to do the higher-level assignments?** 

* **What do you think of the recruitment process?** We want feedback from you so we can continuously improve our processes. 

# Interview agenda 

* Intros 
* Presentation (Intermediate and up)
* Questions

## Next steps after the interview

You will be contacted by HR as to the result of the interview and offer if applicable.

# Appendix

## Publish workflow

This will create a multi-arch image from the `Dockerfile` that is in the repository root.    We don't use GitHub actions in our day-to-day work; we use Azure Pipelines that has a similar concept, as such this information is provided to aide the candidate in completing the assignment.  This should be put in as `.github/workflows/publish.yml` in the Git repository.

```yaml
name: Docker
on: [push]
env:
  REGISTRY: ghcr.io
  IMAGE_NAME: ${{ github.repository }}

jobs:
  build:

    runs-on: ubuntu-latest
    permissions:
      contents: read
      packages: write

    steps:
      - name: Checkout repository
        uses: actions/checkout@v3
      - name: Set up QEMU
        uses: docker/setup-qemu-action@v1
      - name: Setup Docker buildx
        uses: docker/setup-buildx-action@79abd3f86f79a9d68a23c75a09a9a85889262adf
      - name: Log into registry ${{ env.REGISTRY }}
        if: github.event_name != 'pull_request'
        uses: docker/login-action@28218f9b04b4f3f62068d7b6ce6ca5b26e35336c
        with:
          registry: ${{ env.REGISTRY }}
          username: ${{ github.actor }}
          password: ${{ secrets.GITHUB_TOKEN }}
      - name: Extract Docker metadata
        id: meta
        uses: docker/metadata-action@v3
        with:
          images: ${{ env.REGISTRY }}/${{ env.IMAGE_NAME }}
      - name: Build and push Docker image
        id: build-and-push
        uses: docker/build-push-action@v2
        with:
          context: .
          push: ${{ github.event_name != 'pull_request' }}
          tags: ${{ steps.meta.outputs.tags }}
          labels: ${{ steps.meta.outputs.labels }}
          platforms: linux/amd64,linux/arm64,linux/arm/v7

```