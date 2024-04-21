package com.yoga.model.entity;

/**
 *
 *      1 Instructor --------->N yogaclass
 *      1 Instructor <---------1 yogaclass
 *   ------------------------------------------
 *      1---------------------->N
 *
 *      i instructor [yc1,yc2] or yc1-i1
 *
 *
 *         1 Studio --------->N yogaclass
 *  *      1 Studio <---------1 yogaclass
 *  *   ------------------------------------------
 *  *      1---------------------->N
 *     1 studio [yc1,yc2]  or yc1 ----->studio1 yc2---------->studio1
 *
 *
 *         1 user --------->1 yogaclass
 *  *      N user <---------1 yogaclass
 *  *   ------------------------------------------
 *  *      N---------------------->1
 *
 *
 *
 *
 *
 *
 */