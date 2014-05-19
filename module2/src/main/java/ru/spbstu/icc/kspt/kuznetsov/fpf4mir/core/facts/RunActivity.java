/*
 *  We renamed class Build to BuildActivity because we had conflict of
 *  class name "ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Run" with
 *  package name "ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run".
 *  It's not a problem for Java, but a problem for MVEL compiler used by 
 *  Drools 5.5.0.Final
 *  
 *  This problem was observed on Windows OS. 
 */

package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;


public class RunActivity extends Activity {



}
