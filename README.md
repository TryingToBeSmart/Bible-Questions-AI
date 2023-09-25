# CST-323-Activity
## Milestone 1: 08/27/2023
This is a simple web application built with Spring Boot, Thymeleaf, and using Maven dependencies.  
It will follow the MVC design.  MySQL will be used as the database running on MAMP for this first part of the assignment.  
The goal of this application is to learn how to deploy an application onto cloud servers.
As a personal goal, I will attempt to keep all code organized in packages based on features.  Currently, I am using a user package to keep everything regarding the user database, UserModel, and UserController.
My 2nd personal goal is to practice using separate git branches when I work on a new feature.  This will help me learn to collaborate in the future.  

## Milestone 2: 09/03/23
Added the option to delete users from the database. 

## Milestone 3: 09/10/23
Added OpenAI API to send requests and return responses using the /chat page.  The model is not currently trained; it is just using the basic gpt-3.5-turbo model.  I borrowed from the controller, model, and message classes from https://www.baeldung.com/spring-boot-chatgpt-api-openai.  I implemented it to use the /chat view and I will eventually train the model to give responses based on a Biblical viewpoint.  Currently when asked biblical/religious questions, the responses are very neutral.  Example Question: is the bible gods word? Response: "The question of whether the Bible is considered God's word is a matter of personal belief and faith. For many religious individuals and communities, the Bible is considered to be a sacred text inspired by God and containing His teachings and messages. However, it is important to note that different religious traditions may have different interpretations and understandings of the Bible."
I want to train it to use Biblical evidence to reply; for example: "According to 2 Timothy 3:16-17, all scripture is breathed out by God.  The Bible was written by over 40 different writers over the course of over 1500 years, yet the messages are unified about God's character and plans for his creation.  This is evidence that the Bible truly is God's word."  Or something like that.  It will be a fun project if I have time.

## Milestone 4 9/24/23
Added support for AWS Elastic Beanstalk and also Google Cloud hosting.
