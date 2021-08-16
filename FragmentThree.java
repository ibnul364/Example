package com.app.restaurantpos.pos.fragments;

import androidx.fragment.app.Fragment;

import com.app.restaurantpos.R;

import java.util.Calendar;


public class PaymentFragment extends Fragment {
    DatePickerDialog datepicker;
    TextView eText;
    private LinearLayout partialfulllinear, collectionlinear, deliverylinear, awatinglinear ;
    private RadioGroup paymentRadioGroup, fullpartialRadioGroup, radioGroup;
    View view;
    Spinner deliverybyspinner, deliveryatspinner, deliveryatspinner1, collectionhourspinner, collectionminutespinner;
    private RadioButton notpaid, cash, card, paypal, radioButton ;
    public PaymentFragment() {

        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//          Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
        View vw = inflater.inflate(R.layout.fragment_three, container, false);
       View rootView = inflater.inflate(R.layout.fragment_one, container, false);


            view = vw;

            if (view != null) {


//                Calender

                eText = view.findViewById(R.id.editText1);

//                  Spinner


                deliverybyspinner = view.findViewById(R.id.deliveryId);
                deliveryatspinner = view.findViewById(R.id.deliveryId2);
                deliveryatspinner1 = view.findViewById(R.id.deliveryId3);

                initspinnerfooterdeliverybyspinner();
                initspinnerfooterdeliveryatspinner();
                initspinnerfooterdeliveryatspinner1();

//                  Button

                paymentRadioGroup = view.findViewById(R.id.paymentRadioid);
                notpaid = view.findViewById(R.id.notpaidradioid);
                cash = view.findViewById(R.id.cashradioid);
                card = view.findViewById(R.id.cardradioid);
                paypal = view.findViewById(R.id.paypalradioid);

//            Layout

                partialfulllinear = view.findViewById(R.id.partialfullradiolinearid);

                collectionlinear = view.findViewById(R.id.collectionlinearid);
                deliverylinear = view.findViewById(R.id.deliverylinearid);
                awatinglinear = view.findViewById(R.id.awaitinglinearid);

                radioGroup = rootView.findViewById(R.id.radiogroup);

                int selectedId = radioGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioButton = rootView.findViewById(selectedId);

                Toast.makeText(getContext(),
                        radioButton.getText(), Toast.LENGTH_SHORT).show();

                    paymentRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {

                            switch (checkedId) {
                                case R.id.notpaidradioid:
                                    partialfulllinear.setVisibility(View.GONE);
                                    break;

                                case R.id.cashradioid:
                                    partialfulllinear.setVisibility(View.VISIBLE);
                                    break;

                                case R.id.cardradioid:
                                    partialfulllinear.setVisibility(View.VISIBLE);
                                    break;

                                case R.id.paypalradioid:
                                    partialfulllinear.setVisibility(View.VISIBLE);
                                    break;
                            }
                        }
                    });


                    //Calender




                    eText.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            final Calendar cldr = Calendar.getInstance();
                            int day = cldr.get(Calendar.DAY_OF_MONTH);
                            int month = cldr.get(Calendar.MONTH);
                            int year = cldr.get(Calendar.YEAR);
                            // date picker dialog
                            datepicker = new DatePickerDialog(getContext(),
                                    new DatePickerDialog.OnDateSetListener() {
                                        @Override
                                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                            eText.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                        }
                                    }, year, month, day);
                            datepicker.show(); }
                    });
                eText.setText(currentDate());
           }

        return vw;
    }


    String currentDate(){
        StringBuilder sb = new StringBuilder();
        Calendar cal = Calendar.getInstance();

        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);


        sb.append(day+"-");
        sb.append(month+1+"-");
        sb.append(year);

        return sb.toString();

    }


    private void initspinnerfooterdeliverybyspinner() {
        String[] min = new String[]{"5 Minute", "10 Minute", "15 Minute", "20 Minute", "25 Minute", "30 Minute"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.tables_list, min);
        deliverybyspinner.setAdapter(adapter);
        deliverybyspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

    }

    private void initspinnerfooterdeliveryatspinner() {
        String[] hour = new String[]{"13", "14", "15", "16", "17", "18", "19", "20"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.tables_list, hour);
        deliveryatspinner.setAdapter(adapter);
        deliveryatspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

    }


    private void initspinnerfooterdeliveryatspinner1() {
        String[] table = new String[]{"5 Minute", "10 Minute", "15 Minute", "20 Minute", "25 Minute", "30 Minute"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.tables_list, table);
        deliveryatspinner1.setAdapter(adapter);
        deliveryatspinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

    }

}
