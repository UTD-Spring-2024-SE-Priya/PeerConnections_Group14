from datetime import datetime

class CalendarEvent:
    def __init__(self, event_name, start_datetime, end_datetime):
        self.event_name = event_name
        self.start_datetime = start_datetime
        self.end_datetime = end_datetime

    def overlaps_with(self, other_event):
        return not (self.end_datetime < other_event.start_datetime or self.start_datetime > other_event.end_datetime)

class CalendarManager:
    def __init__(self):
        self.calendar_events = []
    
    def is_valid_time(self, datetime_value):
        return 0 <= datetime_value.hour < 24 and 0 <= datetime_value.minute < 60
    
    def is_valid_date_format(self, date_str):
        try:
            datetime.strptime(date_str, '%Y-%m-%d %H:%M:%S')
            return True
        except ValueError as e:
            raise ValueError("Error: Invalid date format!") from e

    def add_event(self, event_name, start_datetime, end_datetime):
        if not self.is_valid_date_format(str(start_datetime)):
            print("Error: Invalid date format!")
            return False
        new_event = CalendarEvent(event_name, start_datetime, end_datetime)

        # Check for overlapping events
        for existing_event in self.calendar_events:
            if new_event.overlaps_with(existing_event):
                print("Error: Overlapping events!")
                return False

        # Check for valid date (present date or future)
        if start_datetime.date() < datetime.now().date():
            print("Error: Invalid start date!")
            return False
        
        if not self.is_valid_time(start_datetime) or not self.is_valid_time(end_datetime):
            print("Error: Invalid time!")
            return False
        
        # Add the event to the calendar
        self.calendar_events.append(new_event)
        print("Event added successfully!")
        return True
    
    

   
