# Servlets: Restaurant

## Step 2: Search your favourite dish:

1. Add ``search.html`` to the webapp directory. Checkout it can be accessed adding its name in the URL.

> No need to add any entry to the web.xml file, because we have not added any servlet. We have added an HTML file, which is directly accessible if located in the webapp directory.

2. Create a servlet for the results of the search, mapping it to the path ``/searchResults.html``.

> How do we extract a parameter value (searchTerm) that was entered in the form? From the ``name`` atribute in the form, to using the ``request`` object to retrieve that value using the ``getParameter("searchTerm")`` method.

