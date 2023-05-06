# Servlets: Restaurant

## Step 3: GET and POST:

Do we use ``<form action="/searchResults.html" method="GET">`` or  
``<form action="/searchResults.html" method="POST">`` ?

GET: key/value pair added in the URL.

```
/searchResults.html?searchTerm=vegetable
```

POST: The data has been transfer within the Http header

POST will be used for LOGIN form.

POST should be used when data is modified, added, deleted ... i.e. there is a side effect and you do not want the action to be repeated by the user.

GET: you can bookmark and link: repeated action with **no side effects**.
