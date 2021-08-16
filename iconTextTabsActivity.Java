
1.	package com.app.restaurantpos.pos;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.app.restaurantpos.R;
import com.app.restaurantpos.pos.fragments.CustomerInfoFragment;
import com.app.restaurantpos.pos.fragments.PaymentFragment;
import com.app.restaurantpos.pos.fragments.ProductsFragment;
import com.google.android.material.tabs.TabLayout;

import java.lang.ref.WeakReference;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class IconTextTabsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.drawable.ic_tab_contacts,
            R.drawable.ic_tab_call,
            R.drawable.ic_tab_favourite
    };

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon_text_tabs);
        
        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true); //for back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//for back button
        getSupportActionBar().setTitle(R.string.place_order);


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_cart, menu);
        return true;
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new CustomerInfoFragment(), "Customer");
        adapter.addFrag(new ProductsFragment(), "Product");
        adapter.addFrag(new PaymentFragment(), "Payment");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public androidx.fragment.app.Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    //for back button
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {


            case R.id.menu_cart_button:
                List<Fragment> allfragments = getActiveFragments();
                for(Fragment fragment : allfragments){
                    if(fragment.getClass() == CustomerInfoFragment.class) {



                        //                                                  Eatin

                        LinearLayout eatenlinearLayout = ((LinearLayout) fragment.getView().findViewById(R.id.eatinliniar));
                        String eaten_linear_layout = String.valueOf(eatenlinearLayout.toString());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+eaten_linear_layout);

                        Spinner eatinTableNoSpinner = ((Spinner) fragment.getView().findViewById(R.id.tblspinner));
                        String tableid = String.valueOf(eatinTableNoSpinner.toString());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+tableid);

                        EditText eatinNumberOfPeople = ((EditText) fragment.getView().findViewById(R.id.no_people));
                        String npp = String.valueOf(eatinNumberOfPeople.getText());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+npp);

                        EditText eatincustomer_name = ((EditText) fragment.getView().findViewById(R.id.no_people));
                        String fff = String.valueOf(eatincustomer_name.getText());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+fff);

                        Spinner eatinWaiterNoSpinner = ((Spinner) fragment.getView().findViewById(R.id.tblspinner));
                        String eatinWaiter = String.valueOf(eatinWaiterNoSpinner.toString());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+eatinWaiter);

                                                            //Collection

                        LinearLayout collectionlinearLayout = ((LinearLayout) fragment.getView().findViewById(R.id.collectionliniar));
                        String collection_linear_layout = String.valueOf(collectionlinearLayout.toString());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+collection_linear_layout);


                        EditText collectionContactNumber = ((EditText) fragment.getView().findViewById(R.id.c_no));
                        String collection_customer_phone = String.valueOf(collectionContactNumber.getText());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+collection_customer_phone);

                        EditText collectionCustomerName = ((EditText) fragment.getView().findViewById(R.id.cs_name));
                        String collection_customer_name = String.valueOf(collectionCustomerName.getText());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+collection_customer_name);

                        EditText collectionNote = ((EditText) fragment.getView().findViewById(R.id.cs_name));
                        String collection_customernote_add_note = String.valueOf(collectionNote.getText());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+collection_customernote_add_note);


//                                                                Delivery

                        LinearLayout deliverylinearLayout = ((LinearLayout) fragment.getView().findViewById(R.id.deliveryliniar));
                        String delivery_linear_layout = String.valueOf(deliverylinearLayout.toString());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+delivery_linear_layout);

                        EditText deliveryContactNumber = ((EditText) fragment.getView().findViewById(R.id.ct_no1));
                        String delivery_customer_phone = String.valueOf(deliveryContactNumber.getText());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+delivery_customer_phone);

                        EditText deliveryCustomerName = ((EditText) fragment.getView().findViewById(R.id.cst_name2));
                        String delivery_customer_name = String.valueOf(deliveryCustomerName.getText());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+delivery_customer_name);

                        Spinner deliveryPostCodeSpinner = ((Spinner) fragment.getView().findViewById(R.id.postspinner));
                        String delivery_customer_postcode = String.valueOf(deliveryPostCodeSpinner.toString());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+delivery_customer_postcode);

                        EditText deliveryCustomerHouseNo = ((EditText) fragment.getView().findViewById(R.id.h_name));
                        String delivery_customer_house = String.valueOf(deliveryCustomerHouseNo.getText());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+delivery_customer_house);

                        EditText deliveryCustomerStreetName = ((EditText) fragment.getView().findViewById(R.id.st_name));
                        String delivery_customer_street = String.valueOf(deliveryCustomerStreetName.getText());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+delivery_customer_street);

                        EditText deliveryCustomerAddress1 = ((EditText) fragment.getView().findViewById(R.id.addrs_lin1));
                        String delivery_customer_addressline1 = String.valueOf(deliveryCustomerAddress1.getText());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+delivery_customer_addressline1);

                        EditText deliveryCustomerAddress2 = ((EditText) fragment.getView().findViewById(R.id.addrs_lin2));
                        String delivery_customer_addressline2 = String.valueOf(deliveryCustomerAddress2.getText());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+delivery_customer_addressline2);

                        EditText deliveryCustomerTown = ((EditText) fragment.getView().findViewById(R.id.deliverytownid));
                        String delivery_customer_city = String.valueOf(deliveryCustomerTown.getText());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+delivery_customer_city);

                        EditText deliveryCustomerDistance = ((EditText) fragment.getView().findViewById(R.id.deliverydistanceid));
                        String delivery_distance = String.valueOf(deliveryCustomerDistance.getText());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+delivery_distance);

                        EditText deliveryCharge = ((EditText) fragment.getView().findViewById(R.id.d_charge));
                        String deliverycharge = String.valueOf(deliveryCharge.getText());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+deliverycharge);

                        EditText deliveryAddressNote = ((EditText) fragment.getView().findViewById(R.id.adds_note));
                        String delivery_addressnote_add_note = String.valueOf(deliveryAddressNote.getText());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+delivery_addressnote_add_note);

                        EditText deliveryCustomerNote = ((EditText) fragment.getView().findViewById(R.id.cs_note));
                        String delivery_customernote_add_note = String.valueOf(deliveryCustomerNote.getText());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+delivery_customernote_add_note);


//                                              Awaiting

                        LinearLayout awaitinglinearLayout = ((LinearLayout) fragment.getView().findViewById(R.id.awaitingliniar));
                        String awaiting_linear_layout = String.valueOf(awaitinglinearLayout.toString());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+awaiting_linear_layout);

                        EditText awaitingContactNumber = ((EditText) fragment.getView().findViewById(R.id.ct_no));
                        String awaiting_customer_phone = String.valueOf(awaitingContactNumber.getText());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+awaiting_customer_phone);

                        EditText awaitingCustomerName = ((EditText) fragment.getView().findViewById(R.id.cst_name));
                        String awaiting_customer_name = String.valueOf(awaitingCustomerName.getText());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+awaitingCustomerName);

                        EditText awaitingCustomerNote = ((EditText) fragment.getView().findViewById(R.id.c_admin));
                        String awaiting_customernote_add_note = String.valueOf(awaitingCustomerNote.getText());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+awaiting_customernote_add_note);


                    }

                    else if(fragment.getClass() == PaymentFragment.class) {

//                              Delivery

                        LinearLayout deliveryLayout = ((LinearLayout) fragment.getView().findViewById(R.id.deliverylinearid));
                        String delivery_layout = String.valueOf(deliveryLayout.toString());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+delivery_layout);

                        TextView deliveryRequastDate = ((TextView) fragment.getView().findViewById(R.id.editText1));
                        String deliveryrequastdate = String.valueOf(deliveryRequastDate.getText());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+deliveryrequastdate);

                        Spinner deliveryReadySpinner = ((Spinner) fragment.getView().findViewById(R.id.deliveryId));
                        String deliveryreadyspinner = String.valueOf(deliveryReadySpinner.toString());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+deliveryreadyspinner);

                        Spinner deliveryAtTimeSpinner1 = ((Spinner) fragment.getView().findViewById(R.id.deliveryId2));
                        String deliveryattimespinner1 = String.valueOf(deliveryAtTimeSpinner1.toString());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+deliveryattimespinner1);

                        Spinner deliveryAtTimeSpinner2 = ((Spinner) fragment.getView().findViewById(R.id.deliveryId3));
                        String deliveryattimespinner2 = String.valueOf(deliveryAtTimeSpinner2.toString());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+deliveryattimespinner2);

                        //                              Collection

                        LinearLayout collectionLayout = ((LinearLayout) fragment.getView().findViewById(R.id.collectionlinearid));
                        String collection_layout = String.valueOf(collectionLayout.toString());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+collection_layout);

                        TextView collectionRequastDate = ((TextView) fragment.getView().findViewById(R.id.editText2));
                        String collectionrequastdate = String.valueOf(collectionRequastDate.getText());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+collectionrequastdate);

                        Spinner collectionReadySpinner = ((Spinner) fragment.getView().findViewById(R.id.collectionId));
                        String collectionreadyspinner = String.valueOf(collectionReadySpinner.toString());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+collectionreadyspinner);

                        Spinner collectionAtTimeSpinner1 = ((Spinner) fragment.getView().findViewById(R.id.collectionId2));
                        String collectionattimespinner1 = String.valueOf(collectionAtTimeSpinner1.toString());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+collectionattimespinner1);

                        Spinner collectionAtTimeSpinner2 = ((Spinner) fragment.getView().findViewById(R.id.collectionId3));
                        String collectionattimespinner2 = String.valueOf(collectionAtTimeSpinner2.toString());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+collectionattimespinner2);

    //                          Awaiting

                        LinearLayout awaitingLayout = ((LinearLayout) fragment.getView().findViewById(R.id.awaitinglinearid));
                        String awaiting_layout = String.valueOf(awaitingLayout.toString());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+awaiting_layout);


                        TextView cawaitingRequastDate = ((TextView) fragment.getView().findViewById(R.id.editText3));
                        String awaitingrequastdate = String.valueOf(cawaitingRequastDate.getText());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+awaitingrequastdate);

                        Spinner awaitingReadySpinner = ((Spinner) fragment.getView().findViewById(R.id.readyId));
                        String awaitingreadyspinner = String.valueOf(awaitingReadySpinner.toString());
                        Log.d("TAG-check-data", "onOptionsItemSelected: "+awaitingreadyspinner);

                    }
                }
                Intent intent = new Intent(getApplicationContext(), ProductCart.class);
                startActivity(intent);
                return true;

            case android.R.id.home:

                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        fragList.add(new WeakReference(fragment));
    }



    List<WeakReference<Fragment>> fragList = new ArrayList<WeakReference<Fragment>>();

    public List<Fragment> getActiveFragments() {
        ArrayList<Fragment> ret = new ArrayList<Fragment>();
        for (WeakReference<Fragment> ref : fragList) {
            Fragment f = ref.get();
            if (f != null) {
                if (f.isVisible()) {
                    ret.add(f);
                }
            }
        }
        return ret;
    }
}

