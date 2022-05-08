# student_25308.Project_Online-Shopping-App
Final Project Mobile App 1 - BSC20921 - Semester 2


Name: Amara Pedroza Terrazas

Student ID:25308

Module : Mobile App 1 – BSC20921

Lecturer Name: Saravanabalagi Ramachandran

# Requirements Checklist


1. Authentication
- [x] Allow User to Signup
- [x] Log In using username and password
- [ ] Store userID and token once logged in, to keep the user logged in (even after restarting the app)

2. Product Listing
- [x] List Product Categories
- [x] On clicking a Category, list Products in that Category
- [x] On clicking a Product, show Product description, show buy button and controls to change quantity.

3. Cart
- [x] Show cart summary
- [x] Show total amount
- [x] Purchase button to place an order, show order notification


4.Show order history
*****Implemented but there is a mistake, I spend more than 10 hr trying to find out without success ****

- [ ] List users orders
- [ ] On clicking an Order, show Order details and Products ordered
- [ ] On clicking a Product, take them to Product description page created for 3.3

5.Show User details
- [x] Use the stored userID to show user details
- [x] Show a random circular profile image from https://thispersondoesnotexist.com/
        **** thispersondoesnotexist didnt work, so I use this cat =)
- [] Show Logout button, on click take back to Signup / Log In page (Restart should not auto login after logout)
        ****** partialy implemented******

6. UI/Implementational Requirements
- [x] RecyclerView used for all Lists: Categories, Products, Orders
- [ ] If logged in, attach authentication token to all requests until logout
- [x] Add a small "About this app" button in the profile page, that shows a page on click with your copyright details and credits

7.Bonus
- [ ] ViewPager2 with bottom TabLayout for: Shop, Cart, Orders, Profile icons
    ******** I started but I didn't had enough time 
- [x] Show a map marker based on the GPS co-ordinates in user profile (Hint: Follow instructions given here)
       *** doesnt work because I dont have access to the Key , I dont want to sign in . 



# Extra features implemented
    


# Report 

The creation of this course was very complicated for me, and it took me a long time to complete, especially the part showing the history of all the purchases. 
The activity passed the data correctly through Gson, but I don't understand why it doesn't show up in the recyclerView. I think that I spent more than 6 hours trying to find the problem in one day ( I spent more time before).

One issue that I have is that the app is super slow. So testing is really complicated. I don't know if my devices are the problem or is the number of requests and the Picasso(). 
Another problem is that it did not work for me https://thispersondoesnotexist.com. It took me a long time to wait, and I got an error on many occasions. As you can see, I changed it for cats (I hope it is not a problem).

Due to lack of time and health complications, I could not make the application in a way that is more user-friendly and improve the UI. But I am happy with the result and can apply the concepts learned. 

Although the application is not perfect (far from it), I am happy with the results. 

I tried to experiment on the application a little bit, to try different ways to get the result. 

I am aware that the code could be more structured and cleaner. 

What I found extremely complicated and that I can't understand how the tokens work to login the user. 

In the map question, I didn't want to generate an API key since it costs, and I had a bad experience using it in the past.
I didn't manage to do some things, but at least I tried. In the future, I will keep trying to improve this project. 

There were many hours invested in the project, but I had fun. 

I take this opportunity to thank you for your time and effort in the class. I just want to tell you that it was very productive because I am happy with what I learned since I had no experience in mobile development and Kotlin. Thank you!





# References 
        https://www.youtube.com/watch?v=EoJX7h7lGxM
        https://www.youtube.com/watch?v=53BsyxwSBJk
        https://guides.codepath.com/android/leveraging-the-gson-library
        https://www.youtube.com/watch?v=hoK9OOP1KZw
        https://www.youtube.com/watch?v=zdfbHzBmzk8
        https://tutorials.eu/json-parsing-and-how-to-use-gson-in-android/
        https://www.youtube.com/watch?v=Sitt4aliSz4
        https://www.youtube.com/watch?v=rBQi_7L-Uc8
        https://www.tutorialspoint.com/gson/gson_quick_guide.htm
        https://developer.android.com/kotlin/style-guide
        https://kotlinlang.org/docs/basic-types.html#string-literals
        https://www.youtube.com/watch?v=UbP8E6I91NA
        https://www.youtube.com/watch?v=dB9JOsVx-yY
        https://www.youtube.com/watch?v=25NXEYeJHAc&t=170s
        https://stackoverflow.com/questions/22490057/android-okhttp-with-basic-authentication
        https://howtoprogram.xyz/2016/11/03/basic-authentication-okhttp-example/
        https://gist.github.com/namhyun-gu/df668e651fe445a55c836284cfbdb215
        https://medium.com/@thoolab/how-to-implement-retrofit-basic-authentication-in-android-kotlin-9f25abe34dda
