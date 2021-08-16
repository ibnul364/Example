package com.app.restaurantpos.pos.fragments;



public class CustomerInfoFragment extends Fragment {
    private LinearLayout eatenlinearLayout, collectionlinearLayout, deliverylinearLayout, awatinglinearLayout;
    private RadioGroup radioGroup;
    View view;
    Intent intent;
    Spinner tblspin, waiterspin, postspin;
    private Fragment fragment;
    private RadioButton eatin, collection, delivery, awaiting;

    DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getContext());

    public CustomerInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//         intent = new Intent(getContext(), ThreeFragment.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_one, container, false);
        view = rootView;


        if (view != null) {

        tblspin = rootView.findViewById(R.id.tblspinner);
        waiterspin = rootView.findViewById(R.id.waiterspinner);
        postspin = rootView.findViewById(R.id.postspinner);
        initspinnerfootertbl();
        initspinnerfooterwaiter();
        initspinnerfooterpost();


            radioGroup = view.findViewById(R.id.radiogroup);

            eatin = view.findViewById(R.id.eatinid);
            collection = view.findViewById(R.id.collectionid);
            delivery = view.findViewById(R.id.deliveryid);
            awaiting = view.findViewById(R.id.awaitingid);

            eatenlinearLayout = view.findViewById(R.id.eatinliniar);
            collectionlinearLayout = view.findViewById(R.id.collectionliniar);
            deliverylinearLayout = view.findViewById(R.id.deliveryliniar);
            awatinglinearLayout = view.findViewById(R.id.awaitingliniar);

            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {

                    switch (checkedId) {

                        case R.id.eatinid:
                            eatenlinearLayout.setVisibility(View.VISIBLE);
                            collectionlinearLayout.setVisibility(View.GONE);
                            deliverylinearLayout.setVisibility(View.GONE);
                            awatinglinearLayout.setVisibility(View.GONE);
                            break;

                        case R.id.collectionid:
                            eatenlinearLayout.setVisibility(View.GONE);
                            collectionlinearLayout.setVisibility(View.VISIBLE);
                            deliverylinearLayout.setVisibility(View.GONE);
                            awatinglinearLayout.setVisibility(View.GONE);
                            break;

                        case R.id.deliveryid:
                            eatenlinearLayout.setVisibility(View.GONE);
                            collectionlinearLayout.setVisibility(View.GONE);
                            deliverylinearLayout.setVisibility(View.VISIBLE);
                            awatinglinearLayout.setVisibility(View.GONE);
                            break;

                        case R.id.awaitingid:
                            eatenlinearLayout.setVisibility(View.GONE);
                            collectionlinearLayout.setVisibility(View.GONE);
                            deliverylinearLayout.setVisibility(View.GONE);
                            awatinglinearLayout.setVisibility(View.VISIBLE);
                            break;
                    }
                }
            });

        }

        return rootView;
    }


    private void initspinnerfootertbl() {

        databaseAccess.open();


        //get data from local database
        List<HashMap<String, String>> cartProductList;
        HashMap<Integer, Integer> tables = databaseAccess.getTables();
        Integer[] table = tables.values().toArray(new Integer[0]);
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(getActivity(), R.layout.tables_list, table);
        tblspin.setAdapter(adapter);
        tblspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }

    private void initspinnerfooterwaiter() {
        String[] waiter = new String[]{"Israk", "Rafin", "Imtiaz", "Eemal", "Arif"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.tables_list, waiter);
        waiterspin.setAdapter(adapter);
        waiterspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }

    private void initspinnerfooterpost() {
        String[] post = new String[]{"3500", "1200", "1110", "1000"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.tables_list, post);
        postspin.setAdapter(adapter);
        postspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }
}
