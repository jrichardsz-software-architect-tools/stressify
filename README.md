# Stressify

Basic http stressor tool focused on Rest Apis.

You just need 5 minutes to get valuable information related to your APIs timing.

![logo](./src/main/resources/edu/utec/tools/stressify/ui/icon.png)

## Version

1.0.5

# Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

# Prerequisites

What things you need to install the software and how to install them

```
java 1.8 or later
```

You can find more detailed instructions on wiki

# Install

- Download latest **stressify.jar** from [here](https://github.com/jrichardsz-software-architect-tools/stressify/releases)


# Start

```
java -jar stressify.jar
```

# Usage

- File > New Project
- Select some method: get, post, put, delete, enter your url and headers like postman

![https://i.ibb.co/sHHztpP/stressify-headers.png](https://i.ibb.co/sHHztpP/stressify-headers.png)

- In the body tab, enter whatever you need but string
- In Assert Response Script tab, left empty or add something like this to ensure that exist a property in your json with **name** as key and **Duke** as value:

```
def status = jsonPath('$.name')
assertThat(status).isEqualTo('Duke')
```
- In settings you must select the report destination, report name and if you want charts:

![https://i.ibb.co/Tmh2hh5/stressify-settings.png](https://i.ibb.co/Tmh2hh5/stressify-settings.png)

- Finally enter the number of virtual users, select the stress mode(sequential/parallel) and press **Start Stress** button:

![https://i.ibb.co/Hq56pMx/stressify-run.png](https://i.ibb.co/Hq56pMx/stressify-run.png)

# Results

Every time you press the **Start Stress** button, you will have these files:

![https://i.ibb.co/NnqSKYY/stressify-report-files.png](https://i.ibb.co/NnqSKYY/stressify-report-files.png)

**csv and xlsx** files which contain valuable data of the stress execution:

![https://i.ibb.co/Wn5Wp4k/stressify-csv-report.png](https://i.ibb.co/Wn5Wp4k/stressify-csv-report.png)

**Columns description**

| field | description |
|-------|-------------|
| id    | unique id of each http request |
| startDate | start date of http request |
| endDate      | end date of http request |
| responseStatus      | status of http request |
| totalExecutionMillisTime  | how long did the http invocation take   |
| log      | message when an error is detected on each http invocation |


**log** file which contain the log of each request and or the errors. You can search here using the id of the csv file

**stats.json** file which contain a summary of the stress. Useful for the future html reports:

```
{
  "totalInvocations" : 10,
  "response200Count" : 10,
  "responseNon200Count" : 0,
  "assertsTrueCount" : 10,
  "assertsFalseCount" : 0,
  "averageResponseTimeMillis" : 851
}
```

**png** file will contain a basic average chart (users vs response time). Red line is the real data and blue the average:

![https://i.ibb.co/f2XH6Wq/stressify-chart.png](https://i.ibb.co/f2XH6Wq/stressify-chart.png)

# Variables


You can use the following jockers on any part of the request (url, header, body) to inject dynamic values instead the same value for all request

| name | description |
|-------|-------------|
| randPosInt    | positive random integer |
| randPosDoub    | positive random double |
| uuid    | random string |

Body Example:

```
{
  "id" : "${uuid}",
  "age" : "${randPosInt}",
  "money" : "${randPosDoub}"
}
```


# Advanced usage

More complex settings and asserts are in the [wiki](https://github.com/jrichardsz-software-architect-tools/stressify/wiki)

# Roadmap

- word and pdf reports
- coverage more than 95%
- more variables
- tutorials
- wiki

# Contributors

<table>
  <tbody>
    <td>
      <img src="https://avatars0.githubusercontent.com/u/3322836?s=460&v=4" width="100px;"/>
      <br />
      <label><a href="http://jrichardsz.github.io/">JRichardsz</a></label>
      <br />
    </td>    
  </tbody>
</table>

## License

This project is licensed under the Apache License V2 License - see the [LICENSE](LICENSE.md) file for details
