
# Rapport

**Assignment 6: Shared preferences**

I denna uppgift har jag lärt mig att använda SharedPreferences. Som tillåter data att bli sparat till
andra aktiviteter. 

- SecondActivity.java
```
protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editTxt = findViewById(R.id.editTxt);
        saveBtn = findViewById(R.id.saveBtn);
        final TextView confTxt = findViewById(R.id.textView2);
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        //prefEditor = sharedPreferences.edit();
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prefEditor = sharedPreferences.edit();
                prefEditor.putString("Data", editTxt.getText().toString());
                prefEditor.apply();
                confTxt.setText("Saved data!");
                finish();
            }
        });
    }
```

- MainActivity.java
```
protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        openPage = findViewById(R.id.openBtn);

        sharedPreferences = getSharedPreferences("MyPrefs",MODE_PRIVATE);
        prefEditor = sharedPreferences.edit();


        sharedTxt = findViewById(R.id.textView);
        openPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        String sharedData = sharedPreferences.getString("Data", "No data found!");
        sharedTxt.setText(sharedData);
    }
```
###Bilder:

![img.png](img.png)
![img_1.png](img_1.png)
![img_2.png](img_2.png)
