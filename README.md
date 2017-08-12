
TODO is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: Prashant Rai

Time spent: 3 hours spent in total

## User Stories

The following **required** functionality is completed:

* [x] User can **successfully add and remove items** from the todo list
* [x] User can **tap a todo item in the list and bring up an edit screen for the todo item** and then have any changes to the text reflected in the todo list.
* [x] User can **persist todo items** and retrieve them properly on app restart

The following **optional** features are NOT implemented:

* [ ] Persist the todo items [into SQLite](http://guides.codepath.com/android/Persisting-Data-to-the-Device#sqlite) instead of a text file
* [ ] Improve style of the todo items in the list [using a custom adapter](http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView)
* [ ] Add support for completion due dates for todo items (and display within listview item)
* [ ] Use a [DialogFragment](http://guides.codepath.com/android/Using-DialogFragment) instead of new Activity for editing items
* [ ] Add support for selecting the priority of each todo item (and display in listview item)
* [ ] Tweak the style improving the UI / UX, play with colors, images or backgrounds

The following **additional** features are NOT implemented:

* [ ] List anything else that you can get done to improve the app functionality!
* [ ] Add location for todo work and get notified when around that area.

## Video Walkthrough 

Here's a walkthrough of implemented user stories:

https://drive.google.com/file/d/0B61kTXs9XkX_MlRWenpEdkZXVlU/view?usp=sharing

<img src='https://github.com/prashantrai/todo-app-android/blob/master/todo1.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Project Analysis

As part of your pre-work submission, please reflect on the app and answer the following questions below:

**Question 1:** "What are your reactions to the Android app development platform so far? Compare and contrast Android's approach to layouts and user interfaces in past platforms you've used."

**Answer:** So far my experience is very exciting and I'd continue this learning make something more interesting.
I coudn't we can develop/add many interesting functionality in very less time.

I'm more on a back-end/platform developer but I've workes couple of project where I had to work on front-end too (mostly web app) with HTML, CSS and some other JS framworks. This is first experience with any mobile development platform and I personally feel the developing UI interface on andriod in interesting. Android provides a variety of pre-built UI components, UI controls that allow us to build the graphical user interface for our app. Android also provides other UI modules for special interfaces such as dialogs, notifications and menus.


**Question 2:** "Take a moment to reflect on the `ArrayAdapter` used in your pre-work. How would you describe an adapter in this context and what is its function in Android? Why do you think the adapter is important? Explain the purpose of the `convertView` in the `getView` method of the `ArrayAdapter`."

**Answer:**

`Adapters` are a bridge between the Adapter View (e.g. `ListView`) and the underlying data for that view. We need to display the items in a list view here and Adapters are responsible for retrieving data from the data set and for generating View objects based on that data. Whenever list view needs to draw a view at a particular list position, it gets it from the adapter. The adapter makes the view for that position and returns it.

`convertView` is the old view to reuse, if possible. Adapter uses the convertView as a way of recycling old View objects that are no longer being used. This parameter is used strictly to increase the performance of `Adapter`. In this way, the ListView can send the Adapter old, "recycled" view objects that are no longer being displayed instead of instantiating an entirely new object each time the Adapter wants to display a new list item.



## Notes

Describe any challenges encountered while building the app.

-This is first app ever for me so took little longer to understand the APIs.

## License

    Copyright [2017] [Prashant Rai]




