# Use_of_Volley_library_In_Android.


1. Add httpmime-4.2.5.jar and gson-2.2.2.jar to your project build path.
2. Add com.infostretch.volydemo.network package.
3. Add com.infostretch.volydemo.volly package.
4. Add com.infostretch.volydemo.VolleySingleton And 
com.infostretch.volydemo.CustomVolleyRequestQueue classes for handling volly library and 
RequestQueue
5. Initialize the requestQueue in your application class/starting phase of your application.
    (Eg. VolleyNetwork.getInstance().init(applicationContext)).
6. You have to create model classes for Request and Response for web services as per your         requirement.
7. Create custom class for calling web service calls by implementing DemoGetRequest<ResponseModel> for get request and DemoPostRequest<RequestModel, ResponseModel> for post request as per your requirement. 
(Eg.SamplePostRequest for Post Request call and SampleGetRequest for Get Request call).
8.  Actual Web Service call:-
     POST: - Refer method callPostService() from MainActivity class.
     GET: - Refer method callGetService() from MainActivity class.

Developed By:- Pravin D. Shinde (pravin.86.shinde@gmail.com)



License

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
