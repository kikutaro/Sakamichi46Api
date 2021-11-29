# Sakamichi46Api
REST API for getting Sakamichi series(坂道シリーズ) Nogizaka46(乃木坂46)/Keyakizaka46(欅坂46) information.

## Available APIs.
+ Member Profile
 - Name
 - Birtyday
 - Blood Type
 - Constellation
 - Profile Photo Url
 - Blog Url
 - Goods Url
 - Matome Url
+ All Member Profile
+ Graduated Member Profile
+ Group Member Count
+ Official Blog Url
+ Official Blog Url for mobile
+ Official Goods Site Url
+ Official Goods Site Url for mobile

## Member Profile
Returns one member profile.
### Resource
```
GET api/{GroupName}/{SubGroupName*}/profile/{member name}
```
*This depends on group.
### Example
#### GET Request
```
http://hostname/sakamichi46api/api/nogizaka46/profile/shiraishimai
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
    "goodsUri": "http://www.nogizaka46shop.com/msp/store/list.cgi?cno=4&cmno=45",
    "matomeUri": [
        "http://nogizaka46democracy.blog.jp/archives/cat_51850.html"
    ]
}
```

## All Member Profile
Returns all profiles of member.
### Resource
```
GET api/{GroupName}/{SubGroupName*}/profile
```
*This depends on group.
### Example
#### GET Request
```
http://hostname/sakamichi46api/api/hiraganakeyaki/profile
```
#### Response
```
[
    {
        "name": "井口眞緒", 
        "birthday": "1995-11-10", 
        "blogUri": "http://www.keyakizaka46.com/mob/news/diarKiji.php?site=k46o&ima=0936&cd=member&ct=23", 
        "bloodType": "AB", 
        "constellation": "さそり座", 
        "goodsUri": null, 
        "matomeUri": [
            "http://www.keyakizaka46matomerabo.com/archives/cat_242368.html"
        ],
        "profilePhotoUri": "http://www.keyakizaka46.com/img/14/orig/k46o/201/610/201610-23__400_320_102400_jpg.jpg"
    }, 
    {
        "name": "潮紗理菜", 
        "birthday": "1997-12-26", 
        "blogUri": "http://www.keyakizaka46.com/mob/news/diarKiji.php?site=k46o&ima=0935&cd=member&ct=24", 
        "bloodType": "O", 
        "constellation": "やぎ座", 
        "goodsUri": null, 
        "matomeUri": [
            "http://www.keyakizaka46matomerabo.com/archives/cat_243105.html"
        ], 
        "profilePhotoUri": "http://www.keyakizaka46.com/img/14/orig/k46o/201/610/201610-24__400_320_102400_jpg.jpg"
    },
    ... 
    ...
]
```
## Group Member Count
Returns number of members.
### Resource
```
GET api/{GroupName}/{SubGroupName*}/count
```
*This depends on group.
### Example
#### GET Request
```
http://hostname/sakamichi46api/api/keyakizaka46/count
```
#### Response
```
20
```
## Official Blog Url
Returns URL of official blog.
### Resource
```
GET api/{GroupName}/{SubGroupName*}/blog
```
*This depends on group.
### Example
#### GET Request
```
http://hostname/sakamichi46api/api/nogizaka46/blog
```
#### Response
```
http://www.nogizaka46.com/
```
## Official Blog Url for mobile
Returns URL of official mobile blog.
### Resource
```
GET api/{GroupName}/{SubGroupName*}/blog/mobile
```
*This depends on group.
### Example
#### GET Request
```
http://hostname/sakamichi46api/api/nogizaka46/blog/mobile
```
#### Response
```
http://www.nogizaka46.com/smph/
```
## Official Goods Site Url
Returns URL of official goods site.
### Resource
```
GET api/{GroupName}/{SubGroupName*}/goods
```
*This depends on group.
### Example
#### GET Request
```
http://hostname/sakamichi46api/api/nogizaka46/goods
```
#### Response
```
http://www.nogizaka46shop.com/
```
## Official Goods Site Url for mobile
Returns URL of official mobile goods site.
### Resource
```
GET api/{GroupName}/{SubGroupName*}/goods/mobile
```
*This depends on group.
### Example
#### GET Request
```
http://hostname/sakamichi46api/api/nogizaka46/goods/mobile
```
#### Response
```
http://www.nogizaka46shop.com/msp/
```
