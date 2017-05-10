# admindroid
Generate code for Material Design with Firebase

With annotations use will be generated Activity and auxiliary classes to show display information of given class.
An example of use is the app of this project.
Below I present the code that will be written and below the code that will be generated.
In the example below just create the Category class with the Admin annotation.

```java
package com.programadorlgam.admindroid;

import com.programadorlgam.Admin;
import com.programadorlgam.Firebase;

/**
 * Created by lukasgarcya on 30/04/17.
 */

@Admin()
@Firebase(path = "category")
public class Category {
    private String name;
}
```

Now the code generate:

```java
package com.programadorlgam.admindroid;

import android.content.Context;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;

public interface CategoryMVP{
    interface View{
        void showToast(String msg);
        void showAlert(String msg);
        void showAddCategoryForm();
        void setAdapter(FirebaseRecyclerAdapter adapter);
        Context getContext();
    }

    interface Presenter {
        void onAddCategoryButtonClicked();
        void loadCategoryAll();
        void onLoadCategorys(DatabaseReference databaseReference);
    }

    interface Model {
        void getCategoryAll();
    }
}
```

```java
package com.programadorlgam.admindroid;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.programadorlgam.admindroidresource.R;

import android.support.v7.widget.RecyclerView;

public class CategoryActivity extends AppCompatActivity implements CategoryMVP.View{
        private Toolbar toolbar;
        private RecyclerView recyclerView;
    private CategoryMVP.Presenter presenter;

	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_line_list);
                toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
                getSupportActionBar().setTitle("Category");
                        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        presenter = new CategoryPresenter(this);
        presenter.loadCategoryAll();
    }

    public void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public void showAlert(String msg){
        Snackbar.make(findViewById(R.layout.activity_single_line_list), msg, Snackbar.LENGTH_LONG).show();
    }

    public void showAddCategoryForm(){
        // Usar fragment
    }

    public void setAdapter(FirebaseRecyclerAdapter adapter){
        this.recyclerView.setAdapter(adapter);
    }

    public Context getContext(){
        return this;
    }
}

```

```java
package com.programadorlgam.admindroid;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.Query;

public class CategoryFirebaseRecyclerAdapter extends FirebaseRecyclerAdapter<Category, CategoryHolder> {
    /**
         * @param modelClass      Firebase will marshall the data at a location into
         *                        an instance of a class that you provide
         * @param modelLayout     This is the layout used to represent a single item in the list.
         *                        You will be responsible for populating an instance of the corresponding
         *                        view with the data from an instance of modelClass.
         * @param viewHolderClass The class that hold references to all sub-views in an instance modelLayout.
         * @param ref             The Firebase location to watch for data changes. Can also be a slice of a location,
         *                        using some combination of {@code limit()}, {@code startAt()}, and {@code endAt()}.
         */
    public CategoryFirebaseRecyclerAdapter(Class<Category> modelClass, int modelLayout, Class<CategoryHolder> viewHolderClass, Query ref) {
        super(modelClass, modelLayout, viewHolderClass, ref);
    }
    protected void populateViewHolder(CategoryHolder viewHolder, Category model, int position) {

    }
}

```

```java

package com.programadorlgam.admindroid;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public class CategoryHolder extends RecyclerView.ViewHolder {
    public CategoryHolder(View itemView){
        super(itemView);
    }
}

```

```java


package com.programadorlgam.admindroid;

import com.google.firebase.database.DatabaseReference;

public class CategoryPresenter implements CategoryMVP.Presenter{

    private CategoryMVP.View view;

    public CategoryPresenter(CategoryMVP.View view){
        this.view = view;
    }

    public void onAddCategoryButtonClicked(){

    }
    public void loadCategoryAll(){

    }
    public void onLoadCategorys(DatabaseReference databaseReference){
        this.view.setAdapter(new CategoryFirebaseRecyclerAdapter(Category.class, R.layout.item_single_line, CategoryHolder.class, databaseReference.child("category")));
    }
}
```
