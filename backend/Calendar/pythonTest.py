import unittest
from datetime import datetime, timedelta
from unittest import result
from calendar_manager import CalendarManager

class TestCalendarManager(unittest.TestCase):
    def setUp(self):
        self.manager = CalendarManager()

    def test_add_event_no_overlap_valid_date(self):
        result = self.manager.add_event("Meeting 1", datetime(2024, 4, 27, 10, 0), datetime(2024, 2, 27, 12, 0))
        self.assertTrue(result, "Non-overlapping event with valid date should be added successfully.")

    def test_add_event_overlap(self):
        self.manager.add_event("Meeting 2", datetime(2024, 2, 27, 10, 0), datetime(2024, 2, 27, 12, 0))
        result = self.manager.add_event("Meeting 3", datetime(2024, 2, 27, 11, 0), datetime(2024, 2, 27, 13, 0))
        self.assertFalse(result, "Overlapping events should not be added.")

    def test_add_event_invalid_date(self):
        result = self.manager.add_event("Meeting 4", datetime(202, 2, 20, 10, 0), datetime(2022, 2, 20, 12, 0))
        self.assertFalse(result, "Events with past dates should not be added.")

    def test_add_event_invalid_time(self):
        with self.assertRaises(ValueError):
            result = self.manager.add_event("Meeting 5", datetime(2024, 2, 24, 10, 70), datetime(2024, 2, 24, 12, 0))
            self.assertFalse(result, "Events with past dates should not be added.")
            

    def test_add_event_invalid_date_format(self):
        # Test case for invalid date format with characters
        with self.assertRaises(ValueError) as context:
            self.manager.add_event("Invalid Event", "/20wq24/12/12", datetime(2024, 2, 24, 12, 0))
        
        self.assertIn("Error: Invalid date format!", str(context.exception))
    
if __name__ == '__main__':
    unittest.main()
