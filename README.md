# Motion Toast - An Beautiful Toast Library for Android Kotlin 🤩🔥 

[![platform](https://img.shields.io/badge/platform-Android-yellow.svg)](https://www.android.com)
[![API](https://img.shields.io/badge/API-11%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=22)
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?style=flat-square)](https://www.apache.org/licenses/LICENSE-2.0.html)

An Beautiful Multipurpose Motion Toast Library in Android using Kotlin 😍

## Preview - Motion Toast 🌟 
![gif](https://github.com/Spikeysanju/Video_templates/blob/master/Motion%20Toast.mov)

## Preview - Color Motion Toast 🌈
![gif](https://github.com/Spikeysanju/Video_templates/blob/master/Toast%20Types-5.png)



<table style="width:100%">
  <tr>
    <th>1. Motion Toast </th>
    <th>2. Color Motion Toast</th> 
  </tr>
  <tr>
    <td><img src = "https://github.com/Spikeysanju/Video_templates/blob/master/Toast%20Types-3.png"/></td> 
    <td><img src = "https://github.com/Spikeysanju/Video_templates/blob/master/Toast%20Types-5.png"/></td> 
   
  </tr>
</table>

## About

An Beautiful Multipurpose Motion Toast Library in Android using Kotlin. 

## Dependency Project Level

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:



```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

```

## Dependency App Level

Add dependency in your app module

```
	dependencies {
	        implementation 'com.github.Spikeysanju:MotionToast:1.0'
	}

```
## Five Toast Types 🖐🏼
```
        1. TOAST_SUCCESS
        2. TOAST_ERROR
        3. TOAST_WARNING
        4. TOAST_INFO
        5. TOAST_DELETE
```

## Toast Duration ⌛️ 
```
        1. LONG_DURATION // 4 Seconds
        2. SHORT_DURATION // 2 Seconds
       
```

## Usage 

# Sample Code for - Motion Toast 🌟 

### Success Toast
```
 MotionToast.createToast(this,"Upload Completed!",
                MotionToast.TOAST_SUCCESS,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.LONG_DURATION,
                ResourcesCompat.getFont(this,R.font.helvetica_regular))
                
```

### Error Toast
```
 MotionToast.createToast(this,"Profile Update Failed!",
                    MotionToast.TOAST_ERROR,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this,R.font.helvetica_regular))  
```
### Warning Toast
```
MotionToast.createToast(this,"Please fill all the details!",
                    MotionToast.TOAST_WARNING,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this,R.font.helvetica_regular))  

        
```

### Info Toast
```
       MotionToast.createToast(this,"This is information toast!",
                    MotionToast.TOAST_INFO,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this,R.font.helvetica_regular))  

```
### Delete Toast
```
       MotionToast.createToast(this,"Delete all history!",
                    MotionToast.TOAST_DELETE,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this,R.font.helvetica_regular))  

```

# Sample Code for - Color Motion Toast 🌈

### Success Toast
```
 MotionToast.createColorToast(this,"Upload Completed!",
                MotionToast.TOAST_SUCCESS,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.LONG_DURATION,
                ResourcesCompat.getFont(this,R.font.helvetica_regular))
                
```

### Error Toast
```
 MotionToast.createColorToast(this,"Profile Update Failed!",
                    MotionToast.TOAST_ERROR,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this,R.font.helvetica_regular))  
```
### Warning Toast
```
MotionToast.createColorToast(this,"Please fill all the details!",
                    MotionToast.TOAST_WARNING,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this,R.font.helvetica_regular))  

        
```

### Info Toast
```
       MotionToast.createColorToast(this,"This is information toast!",
                    MotionToast.TOAST_INFO,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this,R.font.helvetica_regular))  

```
### Delete Toast
```
       MotionToast.createColorToast(this,"Delete all history!",
                    MotionToast.TOAST_DELETE,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.LONG_DURATION,
                    ResourcesCompat.getFont(this,R.font.helvetica_regular))  

```

# Donation
If this project help you reduce time to develop, you can give me a cup of coffee :) 

[![paypal](https://www.paypalobjects.com/en_US/i/btn/btn_donateCC_LG.gif)](https://www.paypal.com/paypalme2/spikeysanju)


## License

* [Apache Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)

```
Copyright 2020 Spikey Sanju

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

