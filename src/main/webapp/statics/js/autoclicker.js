
class Scheduler {
    constructor() {
        this.job = null;
    }

    click() {
        const button = document.querySelector("#btnNext")
        console.log(button)
        if(button) {
            button.click()
            console.log("%...Clicked!...%")
        }
        console.log("%...Loading...%")
    }

    schedule() {
        this.schedule(10000)
    }

    schedule(time) {
        console.log("%...Start job...%")
        clearInterval(this.job)
        this.job = setInterval(this.click, time)
    }

    stop() {
        clearInterval(this.job)
        console.log("stopped!")
    }
}
