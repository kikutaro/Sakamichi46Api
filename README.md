# Sakamichi46Api
[![Build Status](https://travis-ci.org/kikutaro/Sakamichi46Api.svg?branch=master)](https://travis-ci.org/kikutaro/Sakamichi46Api)  
REST API for getting Sakamichi series(坂道シリーズ) Nogizaka46(乃木坂46)/Keyakizaka46(欅坂46) information.

+ Member Profile
 - Name
 - Birtyday
 - Blood Type
 - Constellation
 - Profile Photo Url
 - Blog Url
 - Goods Url
+ All Member Profile
+ Group Member Count
+ Official Blog Url
+ Official Blog Url for mobile
+ Official Goods Site Url
+ Official Goods Site Url for mobile

## Member Profile
Getting one member profile.
### Format
```
GET api/{GroupName}/profile/{member name}
```
### Example
#### GET
```
http://46api.sakamichi46.com/sakamichi46api/api/nogizaka46/profile/shiraishimai
```
#### Response
```
{
    "name": "白石麻衣",
    "birthday": "1992-08-20",
    "bloodType": "A",
    "constellation": "しし座",
    "profilePhotoUri": "http://img.nogizaka46.com/www/member/img/shiraishimai_prof.jpg",
    "blogUri": "http://blog.nogizaka46.com/mai.shiraishi/smph/",
    "goodsUri": "http://www.nogizaka46shop.com/msp/store/list.cgi?cno=4&cmno=45"
}
```
