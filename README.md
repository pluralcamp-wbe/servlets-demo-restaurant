# Servlets: Restaurant

## Step 6: Sessions and Cookies

> HTTP is a stateless protocol: each time we visit a server, once the browser gets the response, the connection is drop and terminated. **No state is preserved** throught the HTTP request-response protocol (the server forgets all about the client).

Cookies are text files sent by the server, stored in the client, and limited in size (4Kb max).

For security reasons, cookies cannot be binary files.

The shopping cart is **not** stored in a cookie.

You cannot always assume that users will allow cookies.

Java api for managing cookies is not easy: best approach is, instead of cookies, use **server side Java Sessions** (its api is so simple): we will ask the Servlets to use a cookie automatically and transparently: this cookie will only store a **unique id** for each user: **the user id**. 

The user id will also be stored in the database, where all the information about the user is persisted: in particular, the user's session data.

> When the user visits again the shop, the server will retrieve the user id from the cookie, find a match in the database, and restore the session for that user.

_This works fine when users allow cookies_.

The servlet api for sessions is really simple:

```java
HttpSession session = request.getSession();
session.setAttribute("cart", cart);
```

If it's the first time the user visits the shop and there is no cookie, ``session`` will get a **blank** HttpSession object back.

If there's a cookie (revisiting user) then we will get the appropiate session object for that user.

HttpSession is like a map.

## Working with sessions

ThankYouServlet gets the total amount of the order in the URL, which is prone to errors, duplicates, etc.

**Instead of including the total in the URL, we will store it in a session variable**. (_In a production system, the amount will be persisted in the database, and the session will contain the user id_). And later on ThankYouServlet will retrieve it from the session to display it on the page.

### Viewing the cookie

Chrome: Developer Tools > Application > Cookies




 














