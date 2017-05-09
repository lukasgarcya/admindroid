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
