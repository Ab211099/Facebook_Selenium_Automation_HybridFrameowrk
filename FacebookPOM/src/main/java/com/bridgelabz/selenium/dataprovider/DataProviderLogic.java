package com.bridgelabz.selenium.dataprovider;

public class DataProviderLogic {


    @org.testng.annotations.DataProvider(name = "dataProvider")
        public Object[][] getDataFromDataProvider() {

                return new Object[][]{
                        {"7972393596", "@bhi007B"}
                };
            }
        }

    //    @org.testng.annotations.DataProvider(name = "dataProvider")
    //    public Object[][] getDataFromDataProvider(Method m) {
    //
    //        if(m.getName().equalsIgnoreCase("dashboardValidation_Success")) {
    //            return new Object[][]{
    //                    {"7972393596", "@bhi007B"}
    //            };
    //        }else {
    //            return new Object[][]{
    //                    {"xyz"},
    //                    {"abc"}
    //            };
    //        }
    //    }

