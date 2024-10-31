try {
  console.log("INITIALIZE DATABASE");
  db.getSiblingDB('lunchify-admin');
  console.log("SWITCHING TO DATABASE: ", db);
  db.createUser(
          {
              user: "lunchify-admin",
              pwd: "pass",
              roles: [
                  {
                      role: "readWrite",
                      db: "lunchify-db"
                  }
              ]
          }
  );

  db.createCollection("meals");
  db.createCollection("users");
  db.createCollection("orders");

  console.log("INSERTING MEALS DATA INTO DATABASE");
  db.meals.insertOne(
    {
      name: "Burek",
      displayName: "Burek - The One",
      ingredients: "Puff-Pastery, Minced Beef, Onions, Oil",
      cautionIngredients: "Not for vegans",
      comments: "Not suitable for Vegans and Vegetarians",
      timestampCreated: new Date(),
      timestampPrepareOn: new Date()
    }
  );

  console.log("INSERTING USERS DATA INTO DATABASE");
  db.users.insertOne(
    {
      name: "Cmarodej Cmar",
      displayName: "Cmarodej",
      email: "cmarizard@gmail.com",
      device: "IOS 18.1",
      active: true
    }
  );

  console.log("INSERTING ORDERS DATA INTO DATABASE");
  db.orders.insertOne(
    {
      userName: "Cmarodej Cmar",
      userId: ObjectId("67213c3cbd0371c86659139f"),
      meals: [
         {
            id: ObjectId("67213b774d39d98aaf59139e"),
            name: "Burek",
            timestampCreated: new Date(),
            timestampPrepareOn: new Date()
          }],
      status: "SUBMITTED",
      timestampCreated: new Date(),
      userComment: "Can I get the re-heated one"
    }
  );
} catch (error) {
  console.error(error);
}