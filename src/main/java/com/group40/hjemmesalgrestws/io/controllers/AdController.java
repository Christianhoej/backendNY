package com.group40.hjemmesalgrestws.io.controllers;

import com.group40.hjemmesalgrestws.dtos.AdDTO;
import com.group40.hjemmesalgrestws.io.models.ads.request.AdDetailsModel;
import com.group40.hjemmesalgrestws.io.models.ads.response.AdRest;
import com.group40.hjemmesalgrestws.io.models.category.request.CategoryDetailsModel;
import com.group40.hjemmesalgrestws.io.models.user.request.UserDetailsModel;
import com.group40.hjemmesalgrestws.io.models.user.request.UserLoginModel;
import com.group40.hjemmesalgrestws.service.AdService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("ads")
public class AdController {

    @Autowired
    AdService adService;

    @CrossOrigin(origins = "*")
    @PostMapping()
    public AdRest createAd(@RequestBody AdDetailsModel adDetails){
        AdRest returnValue = new AdRest();

        AdDTO adDTO = new AdDTO();
        BeanUtils.copyProperties(adDetails,adDTO);

        AdDTO createdAd = adService.createAd(adDTO);
        BeanUtils.copyProperties(createdAd,returnValue);

        return returnValue;

    }
    @CrossOrigin(origins = "*")
    @PutMapping(path = "/{id}")
    public AdRest updateAd(@RequestBody AdDetailsModel adDetails, @PathVariable String id){
        AdRest returnValue = new AdRest();
        BeanUtils.copyProperties(adDetails,returnValue);
        returnValue.setHeader(returnValue.getHeader() + " Dette har ændret sig");
        returnValue.setId(Integer.parseInt(id));
        return returnValue;
    }
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/{id}")
    public AdRest getAd(@PathVariable String id){
        AdRest returnValue = new AdRest();
        List<AdRest> test = new ArrayList<>();
        AdRest c1 = new AdRest();
        c1.setId(1);
        c1.setPrice(700);
        c1.setHeader("ælkiedbguæorehg 1");
        c1.setCategory("Nips");
        c1.setDate("");
        c1.setDescription("Hey");
        c1.setImageURL("https://designme.dk/media/catalog/product/cache/1/image/800x800/17f82f742ffe127f42dca9de82fb58b1/3/9/39256-kay-bojesen-abe-lille-eg-ahorn-3/kay-bojesen-abe-eg-og-ahorn-lille-34.jpg");
        AdRest c2 = new AdRest();
        c2.setId(2);
        c2.setPrice(300);
        c2.setHeader("Overskrift 2");
        c2.setCategory("Nips");
        c2.setDate("");
        c2.setDescription("Hey");
        c2.setImageURL("data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxISEhUTERIWFRMXFxUVFRgVFRkWGBgXFRgXFhUYGBUYHSghGBolGxcXITEhKCkrLi4uFx8zODMsNyktLisBCgoKBQUFDgUFDisZExkrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrK//AABEIAP8AxgMBIgACEQEDEQH/xAAcAAEAAgMBAQEAAAAAAAAAAAAABAUDBgcBAgj/xABNEAABAwIDAwkEBQgGCQUAAAABAAIDBBEFEiEGMXEHEyIyQVFhgbFykaHBFDNCUtEjYoKDkqKywiQ0Q1Nz8BUWF1Rjk9Lh8USjs8Pi/8QAFAEBAAAAAAAAAAAAAAAAAAAAAP/EABQRAQAAAAAAAAAAAAAAAAAAAAD/2gAMAwEAAhEDEQA/AO4rwFYo35sw7jZY30Q3guB8CglIoXNTN3ODh46J9MeOtGeI19EE1FDbiUfaSOIX2K+P7wQSUUc10f3gsbsSiH2vcgmIoP8ApIHqsc7gF5zs7tzA32j8ggnqNPXxs3u17hqVg+gPd9ZKT4N0Cyc3DCMzsrAN7nkD95yDF9Llf9XHYd7tF46imdvnIP5o0Uei2soppxTw1DZJSHEBl3CzRc9MDL8VpO3PKZNS1MlLTQszR5Q6SQlwJc1r+ixpHY4ak+SDeo6mWJ4bN0mO0a8d/cVbLnvJ9tdLiMVQypYwPhyODmAgEPz26JJsRk337VvtKeg3ggyoiICIiAiIgIiICIiCshkyTuYdz+kFy2bayqkq52mWSJ0UhZkzEAAHL1RoekD36Eam66pjUJLQ9vWYb+XauU8pVKIKyCvaLRVA5ubuD2gC54tAP6ooLnFeUSop2Uv5JjxI6SOWR1x022LRlbYC4cDfwOmitsL5QQ97WSwZMzg3M19wLm1yCBp5rTMXw76RSywgdMDnorDXnYbkAeLmF7OLwqvCagTQsk7SLG33hofiEHS5OUihzyMDZXGN7o3ERgDM02Ng5wO/TUdil0e11FLFNNlc1kDc8maME5TfUBtydy5Li8eWsElujVxiTw55l2TDiXNL/wBYFsGybGmd0L/q6iOSnfwe3TzuLeaDZmcpOGnqxSHhEwerlPxLbanhpI6tkL3MkcWNaA1pBBIObWw1B71xTC6csL4njpxPfG7iw2W6YfHz+EVcO90EjZm+DXCx9HnzQW3+1oki1JZvaXS624Bin8p21tVRGAU3NhsgeS5zMxu227WwFj3HeuXRNBA4LeuUVvPYXQz7y0saT7bMrv3mBBS4NtziElVAJqgmN00TXNaxjQWueAQbNvax71j5ZIicSGYktMMZaCdBq4Gw7NR8VrVO8sLXj7JDhxab/JbnyyPY6qgcxzXEwuBsQbZX3F/2kFXyWMy4nBbtbKP/AG3H5KLykx2xWq8TEffDGsmwtSIq6CQgkAv0G/WN4+aj7eVnPYjO/Ll+rFr33RRhBtXI2LNrj+bB/wDaus0fUbwXG+TCSRv0jIDkJhDyBcDr2uezeV2Oh6jUGdERAREQEREBERAREQeOFxY7loG3WDPnoqmlYLyNtPCLXLjGcxY3xc3M3zXQFVY5EQGyt6zDrwQcl2JxIyQxuv04yGuvvu2xaTftIt53VJgrjFWVVK9oaOcfLEBfLlccwD" +
                "b9mQt9x7leYvSijxU5dKetBlZ3CQklw8nlwt/xW9y+tuIbQQ1jB06WQB/jDMQ0jxs+w/WlBTbYzuZTxkNB5qcSX1zAPAa5o8CWs9ys6GbqSsOoyvaeFnD5Kyw90Ze3P0oZAWP7jHK3I74Ov5KhwGJ0LpaWTV8Ej4z4gE5SPDfbwAQQ8UqHHEp3PYGCbLK2wIabgBxF95ve6ucDlmDpYoOtPE+OwbmucpI04Zves+2UOegp6kdeknMbz28zPbU+AdYKHgtXzVRBLfRsjCfZvZ37pKClw1xcwZm5Xgua9p3tc0lpaeFls2I0k02Euex12U78zmlx3NcHOs32XlYNtKLmMQnaBZsjhKPEvALj71sfJ+Oep6ymP249B7TXNP8AKg5oCMq23lFwsNgoaoEnnGWN7WGdjJG+jlptN1bd2h8l0Ta8c5gNG/7joR7mviPxsg1XYqxr6YOALTJYg7tWuClcqkLY8SeGNDQYonWAsL2I7OCrtkn2rqQ/8eL4uA+at+WJtsT408R/ekHyQXPJF9RXcYf511Og6jVyvkh/q9b7UP8AMup4f9W1BJREQEREBERAREQEREBfL2Agg7joV9Ig5pt7gTp6WSNt+fpj9IgI3kN67RxbqB95rVCwCpZW01n9SeN0cgH2S4ZX24OBI4BdBxyItLZm72mx8QuY0VN9CxCalH1M39Kpe4Nd9YwH80i1u5l+1BUbMlwjkp5dJaZ7onDwaSBbw0I8lJ2iGSrp6r7NTHzUv+PBZlyfFvN2H5xWTaOL6PiENQPq6tnMy9wmjAa0+Y5sftlSccozNQzxj6yEiri8DFpL55De3ewILKipRUQ1NJ/vEDwy/wDeMGeM+RBPktFwebnIWk77ZXcW6H4ra9msT0hnHYWvI/iHqFSYtRfR8Qq4B1C8Tx+zMM2ngDogvuUD8pHQ1W/nIubefzmWP8Rd7ll5MqnLWBv32Pb7rP8A5VjqW89g0g3uppg9vsuP4vd7lUbKVXN1dO/s5xoPBxyn4OQUuL03NVNRFbRk0jRwzEj4ELdh+V2beO2Nzj+zPm9CqHlHpubxOfueI5B+k2x+LSti2LbzuDV8XdzxHnE1w+IKDn+ASWqqY908H/yNW0ctLLYhGe+nZ8JJVpmGSWkhd3SRu9zmlbzy3M/pkB74CPc8/igl8kf9Wrfbh+a6ph31bVyrknP9Frfbh+a6TSYjFGwB7w027UFqi0nb3EXT0j4qKoLJ7sLXMc5psHAuGZuouLrkr9nMVf16qpdxmmPzQfpAlYX1cY3vaOLgF+dP9Qap/XfI72g53qpVPyWTH7Tx+q/7oO8yY1TN61RCOMrB6lR3bT0I31lN/wA+P/qXHouSuQb5JfKL/wDSlM5LT/ez/wDLA+ZQdTdtbQD/ANZB5StPoVDn5QMLYbOrYr9wJcfc0Fc/ZyVDtkqPJrfmFKw3kopGTh1QXyRkdWUuYbj7ronN8N9+AQdVoatk0bZYnZmPGZpsRcHwOqLzD6OOGNscTcsbRZouTYb951RBIREQa/tntA2jia50ZkEjiywdlt0Sb7j3LluM7QMqHU7ixzH07y+NzbXs4Wcw3PUNuK7TXUbZW5Xta5u+zgCPDQqnrqGnhLAaePK42uGNFvK2qDk+M4sKqIQyMOUPbI0tFnNc0EAg5tNHEealUmPuY4ODSSARq0EG4yuuL63BK2XDNoKeaeop3UDI5ad5a4Eh2YAlucdAaaX4OHesEuNwtrZKR1DCAI2yxOv9Y02zG2Xo2JItrqxyDU8Pnjgbkja8N10Ou83Opd3qr2r2ke6pY4Qtc9sLYw45uoHOIBa11iR3ldBxvGKanZA80DHsle6Jxz5ebeLZRbIc2YOv2WsVmiq6Z0FRKyiYXRRmXm8/Xa3r9LLpYa7ig07k4xSqq5JabK0RzMeyTK02FmOyG7ibEF11WUbiGi2hb8CNy6VsLi1O9vPwxCMPsHsu" +
                "CWEi4s6wu0i+thuI7Fom0NNzNbUx205wvb7MnSbbyIQXfKy3NPS1A3SwfFpDh8Hqw5ITnZWw97Yz+0JGn0CrdspBLhNBLcZo3mIi+trOZu/Qb718ck+LRw1Uwkdla6G+4nVr22FgO5xQc9DsgP5pPvaf+y6Ly5n8vSO74pfg5h+a5vjrgKioazq87LlPgXG3qtu5Tsa+l/QiGZcsT9c175hF4aILzkpkvSV3twfNdNwemY+PM9gJva5F9BuXG+TqeVsNS1gPNudFnsNPtWu7s+a7XgP1LUEplJGNzGjyCyNYBuAHAL6RAREQEREBRcSizRu7wMw4jX/PFSlHxB+WJ57mu9CgwYNUZ4xfs0Xqj7OD8kvUFqiIgKux6DPCe9tnDyVivmVlwR3gj3oOEbb1RpMXp6uwEU8LGykfasTHIXHvAbG79ALNyjySQyUVWwXbE9zJMoJOSSxFyOy3OW8XeK3jHME+m0NTSWHOWL4r9kkZzM17AT0T4OK1PYWrbXUJp5r5g11NLfrDSzHEH7Q6LvaaUEXbZs0lC5tOC8Z2S2a0vdoDdzLbuiT5LHgeKSPiDoiWySRlhsATd3Rc2xBB1UrYPEXxNDJNJKWQxSDva0kW8RbM2/gqStpvolXUUwNmNfnit9x4Dm24NLPMlBJ5NzLDLJSzNLJGh7XNdvu20jT7s481K5SgWVNNL2SQOYT+dC6+/wBl7R5KdUuvi9HVAdGsp3Zv8WOGRrh5ZfirDlHos+HNlA1hmB/ReMpHm7Ig1GPCjUYbUzNeAaZ7X5cty5pDb6300zdnYvjk0ibLiEcbycr2SDQ2OjS7+VXvJjSSSRV8Jiflmp7NJYQ0uaHgAOItc5/govJ1sZiMVdTzy0zo42Fxc57mDQsc3RoJdfXuQazt9hTabEaiJgIZmD23N/rGh514krZ+UWBn+jcKlaxrS6JocQ0AkuhjJuRv1ats225NpK+s+kNnZEwsY09AvcS29za4G63ar2s2Fpp6SmpJ3PeymDQ0h2QuLWZOlbwO4IND5ILOpcQH+F6SLqezp/o7OCgQ7O0tFTTMpYhGHNu7UuLiBpdziSe33qbs1/V2cEFoiIgIiICIiAoONutBJ7Nvfopyq9pXWp3+JYP3moPvAR+SHH8F4suDttE1EE1ERAREQUFM3LVuG69z7xf8FkdshQF5kNJDmLi8nINXE3JI3Ek66r5rNKth77fgrWur4oG55pWRsvbNI4MFzuF3HfodPBBUVOxeHySumfSsdI4guJLrEjvbfL2dyz4hstRTvD5qaN7g0MBLdzW9UW3WF1Fn25w5m+qYfYDn/wAAKgzcpNAOq6R/sxkfx2QXs+DU4Yy0EY5lr+Zsxv5PMLOyadG/bZYNnNWuHiPmtdHKbA97Y2QS9NzWXcWNAzENvoT3r3FMfdQwOla1rjnaw5yQBcO108QPeg3tFx2XlNrXdVsYH5kMjvjmIUOXbTE3f2r7fmsiZ6gFB25fL5ANSQB4my4NUYxXP608lvzp3D4NuFXyxOf15Wk+N5D8SEHfMSma+CQscHDK7VpBG7wWLZr+rsXDqVksVzFLKwkWPNsyAjuN2kEcVuuAbfSwtDJ6cFn32ua1w/QLtfgg6gioKTbOikNmzWO7VrgPfaw96tYsRhcbNmjce4PaT8CglIsT6lg3vaOLgFDkx2lbvqI79weHH3C5QWKKgm2xom75v3Hj4loCx/69Yf8A7wD7LHu/haUGxql2sdaFo75GD1PyWSl2mo5AC2pj13Bzgx3dq19iD4EKLtVIHMhykEGQG4Nxo134oLfDRaJvBF90gsxvAL1BlREQEREGv4+/JKx4F7AG3AlaXyq42ZqQMbEW2e1+YntDXgNtbx337FvOMtvKweA9VY1uHRTRuikYHRuFiLencRvug/OmHgPa25IeRq3QDS1yDbdr3qd9CtvbbjJ+Dito2l2EfB0mB0kQvZ7es0" +
                "E3s9o32sOl4dm5akyGojJ5t4cN9tL6k9/ZqN3cgytgDXNcGs6JDrgFx0N+5dD2yjvSzAX0kYdLfft28VzmV9Y64cBv06u7o33/AKQXR9qZH/Q6h0Yu/K14A9tjuzwug0SKmcRuceJH8oWVlN35RxcT8HEKudiLWtD5XubwaD8rr5ixeB17SOdb2x8EFsYWjeWjgwD4m4XjqmMac4T4Zhf3MsVTvxOO+kZPkPUrHLjhH2Wt9p3ysEFzzzCCMjzxDz/GLL2nlLd0Pno3+Fx9Frxx2Tsc0eywu/FYX4lKftP8rN/BBtbqiU/ZYOJLv5R6rBJWOHWnY0eFh/E4+i1OSVx36+08n5FfEdybNy37mtJPwPyQbK+vjG+dzvZHzjaFhfiUPaJH8bn+MqBTYJVydSCc/qi0e8tHqrSm2Er3/wBgW+3KB8A4+iCL/pZrepCBxIHoFik2geeqIh73H1Wy0nJVVu6zoWcA559B6q6peSI/2tU79BjW+pd6IOby4rM77ZHgGZfUfNXvJ7O91WAS4jK42Jv2jsBXQaXkmo29d0sntSW/gDVYx7M0dE5pggaHuBGa7ibaX1cSUG2wjojgPRF9NGgRB6iIgIiIKet1qGjuy+t1cKob0qk+B9ArdAVbW4BSym8kDC7vAyu/abYqyRBrr9iqI/2bhwkd8yoVdQsc58LnFsZswkbw0Wtv37gtvWt1kd6gtP2i0e+yDlG3ez747si/L3IOZjTcb7gt93etYwzZqsN7U02tuzL8TZfpOPCYh2KQykYNzQg/P9PsHWv3wtb/AIkl/gLq4o+S2pO+SNnsMc7/AKV1mqxmJhyxjnH/AHYxoOLtwWFrKubrOELe5urv2j8gEGgf7MI425qipeB4ZGX4B1ys1Psfhw3RyzHxc8Dz1AW9nA4mNc83e+xOZ5zH4qbhQGQGwvwQadR7MRD6vD4m9xeM/qPmrqnwqcbmxMHc1unqtkRBTMoKj+8b+wPmsraWpG6Vv7DfwVoiCuAqh2xu/RI9HLKypkHXj82qYiDAyrYe23FVeMOBljAPYT8VcvjB3gFVWIMDXtAG/wCGqC3REQEREBEWGrflY4+BQV+FjNI53H4lWyr8Hjs0nvPorBAREQFr2Im1SD7J91lsK1/GR+Xb4gfNBNqsZYOjGOdd3N3ebv8AysH0Kef65+Vn3Gae/tPmrSnpWM6jQPX3rMgj0lFHGLMaB6qQiIMNZ1HcCsOFfVhZqvqO4FYsM+rCCWiIgIiICIiAqnFfrGcPmrZVeKjps8/VBaIgRAREQFBxZ/QA7z6Kcq2v6UjW/wCdUEyjZZjR4X9+qzIAiAiIgKhxwflWcPmr5UePjpx+fqgvAi8buC9QEREGKq6juBWLDeoFlqeo7gVjw/qIJKIiAiIgIiICrcXGrPP5KyVfi40bxKCe3ci8iOg4BEH0iIgKupelK53df8AptS/K0nwUfDI7Nv3oJiIiAiIgKl2gHSj8/krpU+0A+r4n5ILaPcOAX0viHqjgPRfaAiIgx1PVdwKx0HUWSo6p4LHRdVBIREQEREBERAULFR0R7Q+amqLiQ6B4hBmpz0W8AvF5RnoBEGZERBDxJ2gb3n0UmFlmgeCiSdKW3YP/ACVOQEREBERAVTj40ZxKtlV48Oi3igsKfqt4BZFipuo3gFlQEREGOpPRdwKx0JBYCNQpC8AQeoiICIiAiIgLDWC7HcFmXxMLtPAoMNAegi+cNPR80QS14TZerxwvoUEOgFyXH/N1NXxFEGiwX2gIiICIiAq3HB0W+18lZKvxodAe0PQoJdL1G8FlWGk6jeCzICIiAiIgIiICIiAiIgIURBCw7tCL2l0e4cfVeIJqIiAiIgIiICIiAoGMDoDiPmp6hYt1PMIM9H1G8FmWCi6gWdAREQEREBERAREQEREBERBFETg9x7CvFLRAREQEREBERAREQFDxXqeYUxRcTaTGbeBQf" +
                "dD1As6wUQIYLrOgIiICIiAiIgIiICIiAiIgIiIP/9k=");

        AdRest c3 = new AdRest();
        c3.setId(3);
        c3.setPrice(300);
        c3.setHeader("Overskrift 3");
        c3.setCategory("Nips");
        c3.setDate("");
        c3.setDescription("Hey");
        c3.setImageURL("https://mynewart.dk/477-large_default/ape.jpg");

        AdRest c4 = new AdRest();
        c4.setId(4);
        c4.setPrice(300);
        c4.setHeader("Overskrift 4");
        c4.setCategory("Nips");
        c4.setDate("");
        c4.setDescription("Hey");
        c4.setImageURL("http://uniqamessen.dk/upload_dir/shop/IMG_2288.wm.jpg");

        test.add(c1);
        test.add(c2);
        test.add(c3);
        test.add(c4);

        for(AdRest t : test) {
            if(Integer.toString(t.getId()).equals(id)) {
                returnValue = t;
                break;
            }
            else {
                returnValue.setId(6454);
                returnValue.setHeader(returnValue.getHeader() + " Dette er en specifik ad");
                returnValue.setId(Integer.parseInt(id));
            }
        }
        return returnValue;
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(path = "/{id}")
    public AdRest deleteAd(@RequestBody UserLoginModel userCreds, @PathVariable String id){
        userCreds.getEmail();
        userCreds.getPassword();
        AdRest returnValue = new AdRest();
        returnValue.setHeader(returnValue.getHeader() + " Dette er en specifik ad der er blevet slettet");
        returnValue.setId(Integer.parseInt(id));
        return returnValue;
    }
    @GetMapping()
    @CrossOrigin(origins = "*")
    public List<AdRest> getCategoryAds(/*@RequestBody CategoryDetailsModel categoryDetailsModel /*, @RequestParam(value="page",defaultValue="0") int page, @RequestParam(value="limit",defaultValue="25") int limit*/) {

        List<AdRest> returnValue = new ArrayList<AdRest>();
        AdRest c1 = new AdRest();
        c1.setId(1);
        c1.setPrice(700);
        c1.setHeader("Overskrift 1");
        c1.setCategory("Nips");
        c1.setDate("");
        c1.setDescription("Hey");
        c1.setImageURL("https://designme.dk/media/catalog/product/cache/1/image/800x800/17f82f742ffe127f42dca9de82fb58b1/3/9/39256-kay-bojesen-abe-lille-eg-ahorn-3/kay-bojesen-abe-eg-og-ahorn-lille-34.jpg");
        AdRest c2 = new AdRest();
        c2.setId(2);
        c2.setPrice(300);
        c2.setHeader("Overskrift 2");
        c2.setCategory("Nips");
        c2.setDate("");
        c2.setDescription("Hey");
        c2.setImageURL("data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxISEhUTERIWFRMXFxUVFRgVFRkWGBgXFRgXFhUYGBUYHSghGBolGxcXITEhKCkrLi4uFx8zODMsNyktLisBCgoKBQUFDgUFDisZExkrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrK//AABEIAP8AxgMBIgACEQEDEQH/xAAcAAEAAgMBAQEAAAAAAAAAAAAABAUDBgcBAgj/xABNEAABAwIDAwkEBQgGCQUAAAABAAIDBBEFEiEGMXEHEyIyQVFhgbFykaHBFDNCUtEjYoKDkqKywiQ0Q1Nz8BUWF1Rjk9Lh8USjs8Pi/8QAFAEBAAAAAAAAAAAAAAAAAAAAAP/EABQRAQAAAAAAAAAAAAAAAAAAAAD/2gAMAwEAAhEDEQA/AO4rwFYo35sw7jZY30Q3guB8CglIoXNTN3ODh46J9MeOtGeI19EE1FDbiUfaSOIX2K+P7wQSUUc10f3gsbsSiH2vcgmIoP8ApIHqsc7gF5zs7tzA32j8ggnqNPXxs3u17hqVg+gPd9ZKT4N0Cyc3DCMzsrAN7nkD95yDF9Llf9XHYd7tF46imdvnIP5o0Uei2soppxTw1DZJSHEBl3CzRc9MDL8VpO3PKZNS1MlLTQszR5Q6SQlwJc1r+ixpHY4ak+SDeo6mWJ4bN0mO0a8d/cVbLnvJ9tdLiMVQypYwPhyODmAgEPz26JJsRk337VvtKeg3ggyoiICIiAiIgIiICIiCshkyTuYdz+kFy2bayqkq52mWSJ0UhZkzEAAHL1RoekD36Eam66pjUJLQ9vWYb+XauU8pVKIKyCvaLRVA5ubuD2gC54tAP6ooLnFeUSop2Uv5JjxI6SOWR1x022LRlbYC4cDfwOmitsL5QQ97WSwZMzg3M19wLm1yCBp5rTMXw76RSywgdMDnorDXnYbkAeLmF7OLwqvCagTQsk7SLG33hofiEHS5OUihzyMDZXGN7o3ERgDM02Ng5wO/TUdil0e11FLFNNlc1kDc8maME5TfUBtydy5Li8eWsElujVxiTw55l2TDiXNL/wBYFsGybGmd0L/q6iOSnfwe3TzuLeaDZmcpOGnqxSHhEwerlPxLbanhpI6tkL3MkcWNaA1pBBIObWw1B71xTC6csL4njpxPfG7iw2W6YfHz+EVcO90EjZm+DXCx9HnzQW3+1oki1JZvaXS624Bin8p21tVRGAU3NhsgeS5zMxu227WwFj3HeuXRNBA4LeuUVvPYXQz7y0saT7bMrv3mBBS4NtziElVAJqgmN00TXNaxjQWueAQbNvax71j5ZIicSGYktMMZaCdBq4Gw7NR8VrVO8sLXj7JDhxab/JbnyyPY6qgcxzXEwuBsQbZX3F/2kFXyWMy4nBbtbKP/AG3H5KLykx2xWq8TEffDGsmwtSIq6CQgkAv0G/WN4+aj7eVnPYjO/Ll+rFr33RRhBtXI2LNrj+bB/wDaus0fUbwXG+TCSRv0jIDkJhDyBcDr2uezeV2Oh6jUGdERAREQEREBERAREQeOFxY7loG3WDPnoqmlYLyNtPCLXLjGcxY3xc3M3zXQFVY5EQGyt6zDrwQcl2JxIyQxuv04yGuvvu2xaTftIt53VJgrjFWVVK9oaOcfLEBfLlccwD" +
                "b9mQt9x7leYvSijxU5dKetBlZ3CQklw8nlwt/xW9y+tuIbQQ1jB06WQB/jDMQ0jxs+w/WlBTbYzuZTxkNB5qcSX1zAPAa5o8CWs9ys6GbqSsOoyvaeFnD5Kyw90Ze3P0oZAWP7jHK3I74Ov5KhwGJ0LpaWTV8Ej4z4gE5SPDfbwAQQ8UqHHEp3PYGCbLK2wIabgBxF95ve6ucDlmDpYoOtPE+OwbmucpI04Zves+2UOegp6kdeknMbz28zPbU+AdYKHgtXzVRBLfRsjCfZvZ37pKClw1xcwZm5Xgua9p3tc0lpaeFls2I0k02Euex12U78zmlx3NcHOs32XlYNtKLmMQnaBZsjhKPEvALj71sfJ+Oep6ymP249B7TXNP8AKg5oCMq23lFwsNgoaoEnnGWN7WGdjJG+jlptN1bd2h8l0Ta8c5gNG/7joR7mviPxsg1XYqxr6YOALTJYg7tWuClcqkLY8SeGNDQYonWAsL2I7OCrtkn2rqQ/8eL4uA+at+WJtsT408R/ekHyQXPJF9RXcYf511Og6jVyvkh/q9b7UP8AMup4f9W1BJREQEREBERAREQEREBfL2Agg7joV9Ig5pt7gTp6WSNt+fpj9IgI3kN67RxbqB95rVCwCpZW01n9SeN0cgH2S4ZX24OBI4BdBxyItLZm72mx8QuY0VN9CxCalH1M39Kpe4Nd9YwH80i1u5l+1BUbMlwjkp5dJaZ7onDwaSBbw0I8lJ2iGSrp6r7NTHzUv+PBZlyfFvN2H5xWTaOL6PiENQPq6tnMy9wmjAa0+Y5sftlSccozNQzxj6yEiri8DFpL55De3ewILKipRUQ1NJ/vEDwy/wDeMGeM+RBPktFwebnIWk77ZXcW6H4ra9msT0hnHYWvI/iHqFSYtRfR8Qq4B1C8Tx+zMM2ngDogvuUD8pHQ1W/nIubefzmWP8Rd7ll5MqnLWBv32Pb7rP8A5VjqW89g0g3uppg9vsuP4vd7lUbKVXN1dO/s5xoPBxyn4OQUuL03NVNRFbRk0jRwzEj4ELdh+V2beO2Nzj+zPm9CqHlHpubxOfueI5B+k2x+LSti2LbzuDV8XdzxHnE1w+IKDn+ASWqqY908H/yNW0ctLLYhGe+nZ8JJVpmGSWkhd3SRu9zmlbzy3M/pkB74CPc8/igl8kf9Wrfbh+a6ph31bVyrknP9Frfbh+a6TSYjFGwB7w027UFqi0nb3EXT0j4qKoLJ7sLXMc5psHAuGZuouLrkr9nMVf16qpdxmmPzQfpAlYX1cY3vaOLgF+dP9Qap/XfI72g53qpVPyWTH7Tx+q/7oO8yY1TN61RCOMrB6lR3bT0I31lN/wA+P/qXHouSuQb5JfKL/wDSlM5LT/ez/wDLA+ZQdTdtbQD/ANZB5StPoVDn5QMLYbOrYr9wJcfc0Fc/ZyVDtkqPJrfmFKw3kopGTh1QXyRkdWUuYbj7ronN8N9+AQdVoatk0bZYnZmPGZpsRcHwOqLzD6OOGNscTcsbRZouTYb951RBIREQa/tntA2jia50ZkEjiywdlt0Sb7j3LluM7QMqHU7ixzH07y+NzbXs4Wcw3PUNuK7TXUbZW5Xta5u+zgCPDQqnrqGnhLAaePK42uGNFvK2qDk+M4sKqIQyMOUPbI0tFnNc0EAg5tNHEealUmPuY4ODSSARq0EG4yuuL63BK2XDNoKeaeop3UDI5ad5a4Eh2YAlucdAaaX4OHesEuNwtrZKR1DCAI2yxOv9Y02zG2Xo2JItrqxyDU8Pnjgbkja8N10Ou83Opd3qr2r2ke6pY4Qtc9sLYw45uoHOIBa11iR3ldBxvGKanZA80DHsle6Jxz5ebeLZRbIc2YOv2WsVmiq6Z0FRKyiYXRRmXm8/Xa3r9LLpYa7ig07k4xSqq5JabK0RzMeyTK02FmOyG7ibEF11WUbiGi2hb8CNy6VsLi1O9vPwxCMPsHsu" +
                "CWEi4s6wu0i+thuI7Fom0NNzNbUx205wvb7MnSbbyIQXfKy3NPS1A3SwfFpDh8Hqw5ITnZWw97Yz+0JGn0CrdspBLhNBLcZo3mIi+trOZu/Qb718ck+LRw1Uwkdla6G+4nVr22FgO5xQc9DsgP5pPvaf+y6Ly5n8vSO74pfg5h+a5vjrgKioazq87LlPgXG3qtu5Tsa+l/QiGZcsT9c175hF4aILzkpkvSV3twfNdNwemY+PM9gJva5F9BuXG+TqeVsNS1gPNudFnsNPtWu7s+a7XgP1LUEplJGNzGjyCyNYBuAHAL6RAREQEREBRcSizRu7wMw4jX/PFSlHxB+WJ57mu9CgwYNUZ4xfs0Xqj7OD8kvUFqiIgKux6DPCe9tnDyVivmVlwR3gj3oOEbb1RpMXp6uwEU8LGykfasTHIXHvAbG79ALNyjySQyUVWwXbE9zJMoJOSSxFyOy3OW8XeK3jHME+m0NTSWHOWL4r9kkZzM17AT0T4OK1PYWrbXUJp5r5g11NLfrDSzHEH7Q6LvaaUEXbZs0lC5tOC8Z2S2a0vdoDdzLbuiT5LHgeKSPiDoiWySRlhsATd3Rc2xBB1UrYPEXxNDJNJKWQxSDva0kW8RbM2/gqStpvolXUUwNmNfnit9x4Dm24NLPMlBJ5NzLDLJSzNLJGh7XNdvu20jT7s481K5SgWVNNL2SQOYT+dC6+/wBl7R5KdUuvi9HVAdGsp3Zv8WOGRrh5ZfirDlHos+HNlA1hmB/ReMpHm7Ig1GPCjUYbUzNeAaZ7X5cty5pDb6300zdnYvjk0ibLiEcbycr2SDQ2OjS7+VXvJjSSSRV8Jiflmp7NJYQ0uaHgAOItc5/govJ1sZiMVdTzy0zo42Fxc57mDQsc3RoJdfXuQazt9hTabEaiJgIZmD23N/rGh514krZ+UWBn+jcKlaxrS6JocQ0AkuhjJuRv1ats225NpK+s+kNnZEwsY09AvcS29za4G63ar2s2Fpp6SmpJ3PeymDQ0h2QuLWZOlbwO4IND5ILOpcQH+F6SLqezp/o7OCgQ7O0tFTTMpYhGHNu7UuLiBpdziSe33qbs1/V2cEFoiIgIiICIiAoONutBJ7Nvfopyq9pXWp3+JYP3moPvAR+SHH8F4suDttE1EE1ERAREQUFM3LVuG69z7xf8FkdshQF5kNJDmLi8nINXE3JI3Ek66r5rNKth77fgrWur4oG55pWRsvbNI4MFzuF3HfodPBBUVOxeHySumfSsdI4guJLrEjvbfL2dyz4hstRTvD5qaN7g0MBLdzW9UW3WF1Fn25w5m+qYfYDn/wAAKgzcpNAOq6R/sxkfx2QXs+DU4Yy0EY5lr+Zsxv5PMLOyadG/bZYNnNWuHiPmtdHKbA97Y2QS9NzWXcWNAzENvoT3r3FMfdQwOla1rjnaw5yQBcO108QPeg3tFx2XlNrXdVsYH5kMjvjmIUOXbTE3f2r7fmsiZ6gFB25fL5ANSQB4my4NUYxXP608lvzp3D4NuFXyxOf15Wk+N5D8SEHfMSma+CQscHDK7VpBG7wWLZr+rsXDqVksVzFLKwkWPNsyAjuN2kEcVuuAbfSwtDJ6cFn32ua1w/QLtfgg6gioKTbOikNmzWO7VrgPfaw96tYsRhcbNmjce4PaT8CglIsT6lg3vaOLgFDkx2lbvqI79weHH3C5QWKKgm2xom75v3Hj4loCx/69Yf8A7wD7LHu/haUGxql2sdaFo75GD1PyWSl2mo5AC2pj13Bzgx3dq19iD4EKLtVIHMhykEGQG4Nxo134oLfDRaJvBF90gsxvAL1BlREQEREGv4+/JKx4F7AG3AlaXyq42ZqQMbEW2e1+YntDXgNtbx337FvOMtvKweA9VY1uHRTRuikYHRuFiLencRvug/OmHgPa25IeRq3QDS1yDbdr3qd9CtvbbjJ+Dito2l2EfB0mB0kQvZ7es0" +
                "E3s9o32sOl4dm5akyGojJ5t4cN9tL6k9/ZqN3cgytgDXNcGs6JDrgFx0N+5dD2yjvSzAX0kYdLfft28VzmV9Y64cBv06u7o33/AKQXR9qZH/Q6h0Yu/K14A9tjuzwug0SKmcRuceJH8oWVlN35RxcT8HEKudiLWtD5XubwaD8rr5ixeB17SOdb2x8EFsYWjeWjgwD4m4XjqmMac4T4Zhf3MsVTvxOO+kZPkPUrHLjhH2Wt9p3ysEFzzzCCMjzxDz/GLL2nlLd0Pno3+Fx9Frxx2Tsc0eywu/FYX4lKftP8rN/BBtbqiU/ZYOJLv5R6rBJWOHWnY0eFh/E4+i1OSVx36+08n5FfEdybNy37mtJPwPyQbK+vjG+dzvZHzjaFhfiUPaJH8bn+MqBTYJVydSCc/qi0e8tHqrSm2Er3/wBgW+3KB8A4+iCL/pZrepCBxIHoFik2geeqIh73H1Wy0nJVVu6zoWcA559B6q6peSI/2tU79BjW+pd6IOby4rM77ZHgGZfUfNXvJ7O91WAS4jK42Jv2jsBXQaXkmo29d0sntSW/gDVYx7M0dE5pggaHuBGa7ibaX1cSUG2wjojgPRF9NGgRB6iIgIiIKet1qGjuy+t1cKob0qk+B9ArdAVbW4BSym8kDC7vAyu/abYqyRBrr9iqI/2bhwkd8yoVdQsc58LnFsZswkbw0Wtv37gtvWt1kd6gtP2i0e+yDlG3ez747si/L3IOZjTcb7gt93etYwzZqsN7U02tuzL8TZfpOPCYh2KQykYNzQg/P9PsHWv3wtb/AIkl/gLq4o+S2pO+SNnsMc7/AKV1mqxmJhyxjnH/AHYxoOLtwWFrKubrOELe5urv2j8gEGgf7MI425qipeB4ZGX4B1ys1Psfhw3RyzHxc8Dz1AW9nA4mNc83e+xOZ5zH4qbhQGQGwvwQadR7MRD6vD4m9xeM/qPmrqnwqcbmxMHc1unqtkRBTMoKj+8b+wPmsraWpG6Vv7DfwVoiCuAqh2xu/RI9HLKypkHXj82qYiDAyrYe23FVeMOBljAPYT8VcvjB3gFVWIMDXtAG/wCGqC3REQEREBEWGrflY4+BQV+FjNI53H4lWyr8Hjs0nvPorBAREQFr2Im1SD7J91lsK1/GR+Xb4gfNBNqsZYOjGOdd3N3ebv8AysH0Kef65+Vn3Gae/tPmrSnpWM6jQPX3rMgj0lFHGLMaB6qQiIMNZ1HcCsOFfVhZqvqO4FYsM+rCCWiIgIiICIiAqnFfrGcPmrZVeKjps8/VBaIgRAREQFBxZ/QA7z6Kcq2v6UjW/wCdUEyjZZjR4X9+qzIAiAiIgKhxwflWcPmr5UePjpx+fqgvAi8buC9QEREGKq6juBWLDeoFlqeo7gVjw/qIJKIiAiIgIiICrcXGrPP5KyVfi40bxKCe3ci8iOg4BEH0iIgKupelK53df8AptS/K0nwUfDI7Nv3oJiIiAiIgKl2gHSj8/krpU+0A+r4n5ILaPcOAX0viHqjgPRfaAiIgx1PVdwKx0HUWSo6p4LHRdVBIREQEREBERAULFR0R7Q+amqLiQ6B4hBmpz0W8AvF5RnoBEGZERBDxJ2gb3n0UmFlmgeCiSdKW3YP/ACVOQEREBERAVTj40ZxKtlV48Oi3igsKfqt4BZFipuo3gFlQEREGOpPRdwKx0JBYCNQpC8AQeoiICIiAiIgLDWC7HcFmXxMLtPAoMNAegi+cNPR80QS14TZerxwvoUEOgFyXH/N1NXxFEGiwX2gIiICIiAq3HB0W+18lZKvxodAe0PQoJdL1G8FlWGk6jeCzICIiAiIgIiICIiAiIgIURBCw7tCL2l0e4cfVeIJqIiAiIgIiICIiAoGMDoDiPmp6hYt1PMIM9H1G8FmWCi6gWdAREQEREBERAREQEREBERBFETg9x7CvFLRAREQEREBERAREQFDxXqeYUxRcTaTGbeBQf" +
                "dD1As6wUQIYLrOgIiICIiAiIgIiICIiAiIgIiIP/9k=");

        AdRest c3 = new AdRest();
        c3.setId(3);
        c3.setPrice(300);
        c3.setHeader("Overskrift 3");
        c3.setCategory("Nips");
        c3.setDate("");
        c3.setDescription("Hey");
        c3.setImageURL("https://mynewart.dk/477-large_default/ape.jpg");

        AdRest c4 = new AdRest();
        c4.setId(4);
        c4.setPrice(300);
        c4.setHeader("Overskrift 4");
        c4.setCategory("Nips");
        c4.setDate("");
        c4.setDescription("Hey");
        c4.setImageURL("http://uniqamessen.dk/upload_dir/shop/IMG_2288.wm.jpg");

        returnValue.add(c1);
        returnValue.add(c2);
        returnValue.add(c3);
        returnValue.add(c4);

        return returnValue;
    }
}
